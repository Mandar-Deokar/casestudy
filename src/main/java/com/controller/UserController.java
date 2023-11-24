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
import com.dto.UserDto;
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
			UserDto userDto = userService.get(login);
			if (userDto != null) {
	            return ResponseEntity.ok().body(userDto);
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
				UserDto userDto = userService.create(signup);
				return ResponseEntity.ok(userDto);

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
			UserDto userDto = userService.getbyId(userId);
			if (userDto != null) {
				return ResponseEntity.ok(userDto);
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
