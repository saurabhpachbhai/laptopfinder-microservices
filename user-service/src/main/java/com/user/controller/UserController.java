package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.entity.UserData;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<UserData> saveUserData(@RequestBody UserData userData) {
		UserData savedData = service.saveUserData(userData);
		return new ResponseEntity<UserData>(savedData, HttpStatus.CREATED);
	}

}
