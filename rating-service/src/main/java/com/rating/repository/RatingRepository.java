package com.rating.repository;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	ArrayList<Rating> findByLaptopId(UUID laptopId);

}
