package com.mvs.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvs.beans.Person;
import com.mvs.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {


	@Autowired
	PersonServices services;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll()
			throws Exception {

		return services.findAll();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id)
			throws Exception {
		
		return services.findById(Long.parseLong(id));

	}
	
	@RequestMapping(method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person)
			throws Exception {

		return services.create(person);

	}
	
	@RequestMapping(method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person)
			throws Exception {

		return services.update(person);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET
			)
	public void delete(@PathVariable("id") String id)
			throws Exception {
		services.delete(Long.parseLong(id));
	}
	
	
	
	
}
