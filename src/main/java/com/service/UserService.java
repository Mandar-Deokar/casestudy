package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AddressDto;
import com.dto.LoginRequest;
import com.dto.SignupRequest;
import com.dto.UserDto;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto create(SignupRequest signup) throws Exception {

		User user = userRepository.findByEmailRole(signup.getEmail(), signup.getRole());
		if (user != null) {
			throw new Exception("user already exist");
		}
		user = new User();
		user.setEmail(signup.getEmail());
		user.setName(signup.getName());
		user.setPassword(signup.getPassword());
		user.setRole(signup.getRole());

		user = userRepository.save(user);

		UserDto userDto = new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setUserId(user.getUserId());
		userDto.setRole(signup.getRole());
		userDto.setPhone(user.getPhone());

		return userDto;

	}

	public UserDto get(LoginRequest login) throws Exception {
		User user = userRepository.findbyEmailPassword(login.getEmail(), login.getPassword(), login.getRole());

		if (user == null) {
			throw new Exception("user not found");
		}

		UserDto userDto = new UserDto();

		AddressDto addressDto = new AddressDto();
		if (user.getAddress() != null) {
			if (user.getAddress().getAddressId() > 0) {
				addressDto.setAddressId(user.getAddress().getAddressId());
			}
			if (user.getAddress().getCity() != null) {
				addressDto.setCity(user.getAddress().getCity());
			}
			if (user.getAddress().getPincode() != null) {
				addressDto.setPincode(user.getAddress().getPincode());
			}
			if (user.getAddress().getState() != null) {
				addressDto.setState(user.getAddress().getState());
			}
			if (user.getAddress().getStreet() != null) {
				addressDto.setStreet(user.getAddress().getStreet());
			}
			userDto.setAddress(addressDto);
		}
		

		userDto.setPhone(user.getPhone());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setUserId(user.getUserId());
		userDto.setRole(login.getRole());

		return userDto;
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

//		System.out.println("user got updated");

	}

	public void delete(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		userRepository.delete(user);
//		System.out.println("user got deleted");
	}

	public UserDto getbyId(int userId) {
		User user = userRepository.findById(userId).orElse(null);

		UserDto userDto = new UserDto();

		AddressDto addressDto = new AddressDto();
		if (user.getAddress() != null) {
			if (user.getAddress().getAddressId() > 0) {
				addressDto.setAddressId(user.getAddress().getAddressId());
			}
			if (user.getAddress().getCity() != null) {
				addressDto.setCity(user.getAddress().getCity());
			}
			if (user.getAddress().getPincode() != null) {
				addressDto.setPincode(user.getAddress().getPincode());
			}
			if (user.getAddress().getState() != null) {
				addressDto.setState(user.getAddress().getState());
			}
			if (user.getAddress().getStreet() != null) {
				addressDto.setStreet(user.getAddress().getStreet());
			}
		}
		if (addressDto != null) {
			userDto.setAddress(addressDto);
		}
		if (user.getPhone() != null) {
			userDto.setPhone(user.getPhone());
		}

		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setUserId(user.getUserId());
		userDto.setRole(user.getRole());

		return userDto;

	}

//	public void initUserAndRole() {
//
//		Role adminRole = new Role();
//		adminRole.setRoleName("Admin");
//		roleRepository.save(adminRole);
//
//		Role userRole = new Role();
//		userRole.setRoleName("User");
//		roleRepository.save(userRole);
//
//		User admin = new User();
//		admin.setName("admin");
//		admin.setEmail("admin@pass");
//		admin.setPassword("admin@123");
//		Set<Role> adminroles = new HashSet<Role>();
//		adminroles.add(adminRole);
//		admin.setRole(adminroles);
//		userRepository.save(admin);
//
//		User user = new User();
//		user.setName("admin");
//		user.setEmail("admin@pass");
//		user.setPassword("admin@123");
//		Set<Role> userroles = new HashSet<Role>();
//		userroles.add(userRole);
//		user.setRole(userroles);
//		userRepository.save(user);
//
//	}

}
