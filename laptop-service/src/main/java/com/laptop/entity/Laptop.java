package com.laptop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private UUID laptopId;
	private String brand;
	private String model;
	private double price;
	private String processor;
	private int storage;
	private int ram;
	private double size;

	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
