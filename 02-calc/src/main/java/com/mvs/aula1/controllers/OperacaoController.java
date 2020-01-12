package com.mvs.aula1.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvs.aula1.Greetings;

@RestController
public class GreatingsController {

		private static final String template = "Hello , %s!";
		private static final AtomicLong counter = new AtomicLong();
		
		@RequestMapping("/greetings")
		public Greetings greetings(@RequestParam(value="name", defaultValue = "World") String name) {
			
			return new Greetings(counter.incrementAndGet(), String.format(template, name) );
			
			
		}
	
}
