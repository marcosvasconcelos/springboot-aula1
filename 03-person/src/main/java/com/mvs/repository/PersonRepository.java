package com.mvs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvs.beans.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
