package com.mvs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvs.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
