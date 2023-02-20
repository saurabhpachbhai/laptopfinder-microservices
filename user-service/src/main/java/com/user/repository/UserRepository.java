package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.entity.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {

}
