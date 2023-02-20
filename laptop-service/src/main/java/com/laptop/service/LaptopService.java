package com.laptop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.laptop.entity.Laptop;
import com.laptop.entity.Rating;
import com.laptop.proxy.RatingsProxy;
import com.laptop.repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository repository;

	@Autowired
	public RatingsProxy ratingsProxy;

	public Laptop saveLaptop(Laptop laptop) {

		laptop.setLaptopId(UUID.randomUUID());
		return repository.save(laptop);
	}

	public List<Laptop> getAllLaptops(Integer pageNumber, Integer pageSize) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Laptop> laptopPage = repository.findAll(pageable);
		List<Laptop> laptops = laptopPage.getContent();
		return laptops;
	}

	public Laptop getByLaptopId(UUID laptopId) {

		List<Rating> rating = ratingsProxy.getRatingsByLaptopId(laptopId).getBody();
		Laptop laptop = repository.findByLaptopId(laptopId);
		laptop.setRatings(rating);
		return laptop;
	}

	public List<Laptop> getLaptopWithInBudget(int min, int max) {

		List<Laptop> laptops = repository.findAll();
		List<Laptop> budgetLaptops = new ArrayList<>();

		for (int i = 0; i < laptops.size(); i++) {
			if (laptops.get(i).getPrice() >= min && laptops.get(i).getPrice() <= max) {
				budgetLaptops.add(laptops.get(i));
			}
		}

		return budgetLaptops;
	}

	public List<Laptop> getLaptopByBrand(String brand) {

		return repository.findByBrand(brand);
	}

}
