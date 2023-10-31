package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserAddress;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Integer>{

}
