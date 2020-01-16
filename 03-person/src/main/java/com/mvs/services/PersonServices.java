package com.mvs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvs.beans.Person;
import com.mvs.exception.ResourceNotFoundException;
import com.mvs.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	public Person findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

	}

	public List<Person> findAll() {
		return repository.findAll();

	}

	public Person create(Person p) {
		repository.save(p);
		return p;

	}

	public Person update(Person person) {

		Person entityP = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Records found for this ID!"));

		entityP.setNome(person.getNome());
		entityP.setSobreNome(person.getSobreNome());
		entityP.setEndereco(person.getEndereco());
		entityP.setGenero(person.getGenero());

		return repository.save(entityP);

	}

	public void delete(Long id) {

		Person entityP = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entityP);

	}

}
