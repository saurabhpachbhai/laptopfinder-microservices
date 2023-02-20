package com.laptop.controller;

import java.util.List;
import java.util.UUID;
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
import com.laptop.entity.Laptop;
import com.laptop.service.LaptopService;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

	@Autowired
	private LaptopService service;

	@PostMapping("/add")
	public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
		Laptop saveLaptop = service.saveLaptop(laptop);
		return new ResponseEntity<Laptop>(saveLaptop, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Laptop>> getAlLaptops(
			@RequestParam(value = "pageNumber" , defaultValue = "0" ,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5" , required = false) Integer pageSize) {

		List<Laptop> laptops = service.getAllLaptops(pageNumber,pageSize);
		return new ResponseEntity<List<Laptop>>(laptops, HttpStatus.OK);
	}

	@GetMapping("/{laptopId}")
	public ResponseEntity<Laptop> getByLaptopId(@PathVariable UUID laptopId) {
		Laptop laptop = service.getByLaptopId(laptopId);
		return new ResponseEntity<Laptop>(laptop, HttpStatus.OK);
	}

	@GetMapping("bybudget/{min}/to/{max}")
	public ResponseEntity<List<Laptop>> getLaptopWithInBudget(@PathVariable int min, @PathVariable int max) {
		List<Laptop> laptops = service.getLaptopWithInBudget(min, max);
		return new ResponseEntity<List<Laptop>>(laptops, HttpStatus.OK);
	}

	@GetMapping("/bybrand/{brand}")
	public ResponseEntity<List<Laptop>> getLaptopByBrand(@PathVariable String brand) {
		List<Laptop> laptops = service.getLaptopByBrand(brand);
		return new ResponseEntity<List<Laptop>>(laptops, HttpStatus.OK);
	}
}
