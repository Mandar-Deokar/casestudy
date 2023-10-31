package com.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	@Column(name = "name", length = 5, nullable = false) 
	private String name;
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "phone", nullable = false, length = 10)
	private String phone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private UserAddress address;
	@Column(name = "password", nullable = false)
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String name,
			@NotBlank @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format") String email,
			String phone, UserAddress address, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
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

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", password=" + password + "]";
	}
	
	

}
