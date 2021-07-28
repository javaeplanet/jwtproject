package com.javaeplanet.jwt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaeplanet.jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String Username);
}
