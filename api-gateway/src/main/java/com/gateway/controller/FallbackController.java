package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/userservicefallback")
	public String userServiceFallback() {
		return "user service taking long time"+" Please try again after some time";
	}
	@GetMapping("/laptopservicefallback")
	public String laptopServiceFallback() {
		return "laptop service taking long time"+" Please try again after some time";
	}
	@GetMapping("/ratingservicefallback")
	public String ratingServiceFallback() {
		return "rating service taking long time"+" Please try again after some time";
	}
	@GetMapping("/usedlaptopservicefallback")
	public String usedlaptopServiceFallback() {
		return "used laptop service taking long time"+" Please try again after some time";
	}
}
