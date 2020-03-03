package com.mvs.coverter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.mvs.data.model.Person;
import com.mvs.data.vo.Person2VO;

@Service
public class PersonConverter {

	public Person2VO converterEntityToVO(Person person) {
		Person2VO vo = new Person2VO();
		vo.setId(person.getId());
		vo.setNome(person.getNome());
		vo.setSobreNome(person.getSobreNome());
		vo.setGenero(person.getGenero());
		vo.setEndereco(person.getEndereco());
		vo.setDtNascimento(new Date());
		
		return vo;
		
	}
	
	public Person converterVOToEntity(Person2VO person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setNome(person.getNome());
		entity.setSobreNome(person.getSobreNome());
		entity.setGenero(person.getGenero());
		entity.setEndereco(person.getEndereco());
		
		return entity;
		
	}
}
