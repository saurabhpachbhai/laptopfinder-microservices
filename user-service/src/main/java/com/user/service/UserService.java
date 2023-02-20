package com.user.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.entity.UserData;
import com.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public UserData saveUserData(UserData userData) {
		
		userData.setUserId(UUID.randomUUID());
		return repository.save(userData);
	}


}
