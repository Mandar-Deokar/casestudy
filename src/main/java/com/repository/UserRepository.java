package com.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password AND u.role = :role")
    User findbyEmailPassword(@Param("email") String email, @Param("password") String password, @Param("role") String role);
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.role = :role")
    User findByEmailRole(@Param("email") String email, @Param("role") String role);
}
