package com.laptop.entity;

import java.util.UUID;
import lombok.Data;

@Data
public class Rating {
	private UUID userId;
	private double rating;
	private String review;

}
