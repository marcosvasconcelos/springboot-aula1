package com.mvs.repository;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.mvs.data.model.Person;

@Repository
public interface IElasticSearchRepo {
	
	public void salvar(Person person) throws IOException;

}
