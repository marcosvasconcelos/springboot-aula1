package com.mvs.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mvs.beans.Person;
import com.mvs.repository.ElasticSearchRepo;
import com.mvs.repository.PersonRepository;


@Component
public class TaskComponent {
	
	
	//@Autowired
	ElasticSearchRepo repository = new ElasticSearchRepo();
	
	@Autowired
	PersonRepository personRepo;
	
	
	@Scheduled(fixedRate = 10000)
	public void execute() {

		try {
			
			System.out.println("INICIO");
			List<Person> list = personRepo.findAll();

			for (Person person : list) {
				System.out.println("PESSOA -- " + person.getNome());
				repository.salvar(person);
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
