package com.groupid.formsubmit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.groupid.formsubmit.FormsubmitApplication;
import com.groupid.formsubmit.entities.Animal;
import com.groupid.formsubmit.entities.AnimalRepository;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormsubmitApplication.class);
	
	@Bean
	public CommandLineRunner demo(AnimalRepository repository) {
		return (args) -> {
			repository.save(new Animal("Tulipa", "Vira Lata"));
			repository.save(new Animal("Nina", "Frajola"));
			repository.save(new Animal("Kaia", "Khao Manee"));
			
			log.info("-------------------------------------------");
			log.info("== Animais encontrados com findAll():");
			for (Animal animal : repository.findAll()) {
				log.info(animal.toString());
			}
			log.info("");
			
			Animal animal = repository.findById(1L);
			log.info("== Animais encontrados com findById(1L):");
			log.info(animal.toString());
			log.info("");
			
			log.info("== Animais encontrados com FindByNome('Nina'):");
			repository.findByNome("Nina").forEach(nina -> {
				log.info(nina.toString());
			});
			log.info("");
			
			log.info("-------------------------------------------");
		};
	}
}
