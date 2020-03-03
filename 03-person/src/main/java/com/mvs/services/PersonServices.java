package com.mvs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvs.coverter.DozerConverter;
import com.mvs.coverter.custom.PersonConverter;
import com.mvs.data.model.Person;
import com.mvs.data.vo.Person2VO;
import com.mvs.data.vo.PersonVO;
import com.mvs.exception.ResourceNotFoundException;
import com.mvs.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;

	public PersonVO findById(Long id) {

		var entityID = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerConverter.parserObject(entityID, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parserListObjects(repository.findAll(), PersonVO.class);

	}

	public PersonVO create(PersonVO p) {
		var entityPerson = DozerConverter.parserObject(p, Person.class);
		var voPerson = DozerConverter.parserObject(repository.save(entityPerson), PersonVO.class);
		repository.save(entityPerson);
		return voPerson;

	}

	public Person2VO createV2(Person2VO person) {
		var entityPerson = converter.converterVOToEntity(person);
		var voPerson = converter.converterEntityToVO(repository.save(entityPerson));
		return voPerson;

	}

	public PersonVO update(PersonVO person) {

		var entityP = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Records found for this ID!"));

		entityP.setNome(person.getNome());
		entityP.setSobreNome(person.getSobreNome());
		entityP.setEndereco(person.getEndereco());
		entityP.setGenero(person.getGenero());

		var voEntity = DozerConverter.parserObject(repository.save(entityP), PersonVO.class);
		return voEntity;

	}

	public void delete(Long id) {

		var entityP = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entityP);

	}

}
