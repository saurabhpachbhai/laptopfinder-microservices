package com.laptop.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.laptop.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	Laptop findByLaptopId(UUID laptopId);

	List<Laptop> findByBrand(String brand);

}
