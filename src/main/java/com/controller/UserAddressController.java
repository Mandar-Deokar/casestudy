package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;

@RestController
public class UserAddressController {
	
	@Autowired
	UserService userService;
}
