package com.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoginRequest;
import com.dto.SignupRequest;
import com.entity.Role;
import com.entity.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
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
		tempUser.setRole(user.getRole());
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
	
	public void initUserAndRole() {
		
	 Role adminRole = new Role();
	 adminRole.setRoleName("Admin");
	 roleRepository.save(adminRole);
	 
	 Role userRole = new Role();
	 userRole.setRoleName("User");
	 roleRepository.save(userRole);
	 
	 
	 User admin = new User();
	 admin.setName("admin");
	 admin.setEmail("admin@pass");
	 admin.setPassword("admin@123");
	 Set<Role> adminroles = new HashSet<Role>();
	 adminroles.add(adminRole);
	 admin.setRole(adminroles);
	 userRepository.save(admin);
	 
	 User user = new User();
	 user.setName("admin");
	 user.setEmail("admin@pass");
	 user.setPassword("admin@123");
	 Set<Role> userroles = new HashSet<Role>();
	 userroles.add(userRole);
	 user.setRole(userroles);
	 userRepository.save(user); 
		
	}
	
}
