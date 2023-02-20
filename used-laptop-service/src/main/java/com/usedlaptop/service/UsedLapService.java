package com.usedlaptop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.usedlaptop.entity.UsedLaptop;
import com.usedlaptop.repository.UsedLaptopRepository;

@Service
public class UsedLapService {

	
	@Autowired
	private UsedLaptopRepository repository;
	public UsedLaptop saveUsedLaptop(UsedLaptop usedLaptop) {
		usedLaptop.setLaptopId(UUID.randomUUID());
		return repository.save(usedLaptop);
	}
	
	public List<UsedLaptop> getallUsedLaptops(Integer pageNumber, Integer pageSize) {

		
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<UsedLaptop> laptoppages = repository.findAll(pageable);
		List<UsedLaptop> laptops = laptoppages.getContent();
		return laptops;
	}

	public List<UsedLaptop> getUsedLaptopWithInBudget(int min, int max) {
		List<UsedLaptop> laptops = repository.findAll();
		List<UsedLaptop> usedBudgetLaptops = new ArrayList<>();

		for (int i = 0; i < laptops.size(); i++) {
			if (laptops.get(i).getPrice() >= min && laptops.get(i).getPrice() <= max) {
				usedBudgetLaptops.add(laptops.get(i));
			}
		}

		return usedBudgetLaptops;
	}

	public List<UsedLaptop> getUsedLaptopByBrand(String brand) {
		return repository.findByBrand(brand);
	}

}
