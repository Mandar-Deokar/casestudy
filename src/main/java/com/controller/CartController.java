package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;

}
