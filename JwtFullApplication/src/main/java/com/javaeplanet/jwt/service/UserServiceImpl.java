package com.javaeplanet.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaeplanet.jwt.entity.User;
import com.javaeplanet.jwt.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository repos;

	@Override
	public Integer saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repos.save(user).getId();
	}

}
