package com.usedlaptop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.usedlaptop.entity.UsedLaptop;
import com.usedlaptop.service.UsedLapService;

@RestController
@RequestMapping("/usedlaptops")
public class UsedLapController {

	@Autowired
	private UsedLapService service;
	
	@PostMapping("/add")
	public ResponseEntity<UsedLaptop> saveUsedLaptop(@RequestBody UsedLaptop usedLaptop) {
		UsedLaptop savedLaptop= service.saveUsedLaptop(usedLaptop);
		return new ResponseEntity<UsedLaptop>(savedLaptop,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UsedLaptop>> getallUsedLaptops(
			@RequestParam(value = "pageNumber" ,defaultValue = "0" , required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false)Integer pageSize){
		List<UsedLaptop> laptops= service.getallUsedLaptops(pageNumber,pageSize);
		return new ResponseEntity<List<UsedLaptop>>(laptops,HttpStatus.OK);
	}
	@GetMapping("bybudget/{min}/to/{max}")
	public ResponseEntity<List<UsedLaptop>> getUsedLaptopWithInBudget(@PathVariable int min, @PathVariable int max) {
		List<UsedLaptop> laptops = service.getUsedLaptopWithInBudget(min, max);
		return new ResponseEntity<List<UsedLaptop>>(laptops, HttpStatus.OK);
	}

	@GetMapping("/bybrand/{brand}")
	public ResponseEntity<List<UsedLaptop>> getUsedLaptopByBrand(@PathVariable String brand) {
		List<UsedLaptop> laptops = service.getUsedLaptopByBrand(brand);
		return new ResponseEntity<List<UsedLaptop>>(laptops, HttpStatus.OK);
	}
}
