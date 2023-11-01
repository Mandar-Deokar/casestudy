package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoginRequest;
import com.dto.SignupRequest;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User create(SignupRequest signup){
		User user = new User();
		user.setEmail(signup.getEmail());
		user.setName(signup.getName());
		user.setPassword(signup.getPassword());
		user = userRepository.save(user);
		return user;
		
	}
	
	public User get(LoginRequest login) {
		User user  = userRepository.findbyEmailPassword(login.getEmail(), login.getPassword());
		return user;
	}
	
	public void update(User user) {
		User tempUser = userRepository.findById(user.getUserId()).orElse(null);
		tempUser.setName(user.getName());
		tempUser.setEmail(user.getEmail());
		tempUser.setPhone(user.getPhone());
		tempUser.setAddress(user.getAddress());
		tempUser.setPassword(user.getPassword());
		userRepository.save(tempUser);
		System.out.println("user got updated");

	}
	
	public void delete (int userId) {
		User user = userRepository.findById(userId).orElse(null);
		userRepository.delete(user);
		System.out.println("user got deleted");
	}
	
	public User getbyId(int userId) {
		User user  = userRepository.findById(userId).orElse(null);
		return user;
	}
	
}
