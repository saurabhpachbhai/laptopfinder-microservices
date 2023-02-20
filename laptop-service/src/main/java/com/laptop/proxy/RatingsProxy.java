package com.laptop.proxy;

import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.laptop.entity.Rating;

@FeignClient(name = "ratingfeign", url = "localhost:9013/ratings")
public interface RatingsProxy {

	@GetMapping("/{laptopId}")
	public ResponseEntity<List<Rating>> getRatingsByLaptopId(@PathVariable UUID laptopId);

}
