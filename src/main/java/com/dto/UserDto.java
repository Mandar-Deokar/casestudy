package com.dto;

import java.util.Set;

import com.entity.Role;

public class UserResponse {
	
	int userId;
	String name;
	String email;
	String phone;
	String address;
	Set<Role> role;
	
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponse(int userId, String name, String email, String phone, String address, Set<Role> role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", role=" + role + "]";
	}
	
	
}
