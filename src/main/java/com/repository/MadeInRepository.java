package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.MadeIn;

@Repository
public interface MadeInRepository extends JpaRepository<MadeIn, Integer> {
	String string = "SELECT m FROM MadeIn m  WHERE "
			+ "LOWER(m.madeInName) LIKE LOWER(concat(:madeInName)) ";

	@Query(string)
	MadeIn getmadeIn(@Param("madeInName") String madeInName);
}
