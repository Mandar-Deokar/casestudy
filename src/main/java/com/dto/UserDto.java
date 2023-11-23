package com.dto;

public class UserDto {
	
	int userId;
	String name;
	String email;
	String phone;
	AddressDto address;
	String role;
	
	public UserDto() {
		super();
	}

	public UserDto(int userId, String name, String email, String phone, AddressDto address, String role) {
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

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", role=" + role + "]";
	}
	
	
}
