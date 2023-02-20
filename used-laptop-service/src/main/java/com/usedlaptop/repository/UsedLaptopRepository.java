package com.usedlaptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usedlaptop.entity.UsedLaptop;

public interface UsedLaptopRepository  extends JpaRepository<UsedLaptop, Integer>{

	List<UsedLaptop> findByBrand(String brand);

}
