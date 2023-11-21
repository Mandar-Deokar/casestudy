package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginRequest;
import com.dto.SignupRequest;
import com.entity.User;
import com.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
//	@PostConstruct
//	public void initUserAndRoles() {
//		userService.initUserAndRole();
//	}

	@PostMapping("/login")
	public ResponseEntity<?> getlogin(@RequestBody LoginRequest login) {
		try {
			User user = userService.get(login);
			if (user != null) {
	            return ResponseEntity.ok().body(user);
			} 
			else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> getsignup(@RequestBody SignupRequest signup) {
		try {
			if (signup != null) {
				User user = userService.create(signup);
				return ResponseEntity.ok(user.getUserId());

			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/getprofile/{userId}")
	public ResponseEntity<?> getprofile(@PathVariable int userId) {
		try {
			User user = userService.getbyId(userId);
			if (user != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateprofile(@RequestBody User user) {
		try {
			if (user != null) {
				userService.update(user);
				return ResponseEntity.ok("Sucess");
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	

}
