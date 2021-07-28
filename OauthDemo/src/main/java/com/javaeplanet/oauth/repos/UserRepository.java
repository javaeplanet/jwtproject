package com.javaeplanet.oauth.repos;

import org.springframework.data.repository.CrudRepository;

import com.javaeplanet.oauth.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByName(String name);
}
