package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.MadeIn;

public interface MadeInRepository extends JpaRepository<MadeIn, Integer> {

}
