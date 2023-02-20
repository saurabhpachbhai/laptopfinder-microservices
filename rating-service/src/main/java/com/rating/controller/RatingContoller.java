package com.rating.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingContoller {

	@Autowired
	private RatingService service;

	@PostMapping("/add")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		Rating savedRating = service.saveRating(rating);
		return new ResponseEntity<Rating>(savedRating, HttpStatus.CREATED);
	}

	@GetMapping("/{laptopId}")
	public ResponseEntity<List<Rating>> getRatingsByLaptopId(@PathVariable UUID laptopId) {
		List<Rating> ratings = service.getRatingsByLaptopId(laptopId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}
}
