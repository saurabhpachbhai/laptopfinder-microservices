package com.rating.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rating.entity.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository repository;

	public Rating saveRating(Rating rating) {
		return repository.save(rating);
	}

	public List<Rating> getRatingsByLaptopId(UUID laptopId) {
		// TODO Auto-generated method stub
		return repository.findByLaptopId(laptopId);
	}

}
