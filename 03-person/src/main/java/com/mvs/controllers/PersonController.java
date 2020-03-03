package com.mvs.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvs.data.vo.Person2VO;
import com.mvs.data.vo.PersonVO;
import com.mvs.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {


	@Autowired
	PersonServices services;
	
	@GetMapping
	public List<PersonVO> findAll()
			throws Exception {

		return services.findAll();

	}
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") String id)
			throws Exception {
		
		return services.findById(Long.parseLong(id));

	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person)
			throws Exception {

		return services.create(person);

	}
	@PostMapping("/v2")
	public Person2VO createV2(@RequestBody Person2VO person)
			throws Exception {

		return services.createV2(person);

	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person)
			throws Exception {

		return services.update(person);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id)
			throws Exception {
		services.delete(Long.parseLong(id));
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
