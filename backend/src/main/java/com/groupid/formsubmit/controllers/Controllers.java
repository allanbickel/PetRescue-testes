package com.groupid.formsubmit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupid.formsubmit.FormsubmitApplication;
import com.groupid.formsubmit.entities.Animal;
import com.groupid.formsubmit.entities.AnimalRepository;


@RestController
public class Controllers {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormsubmitApplication.class);
	
	private final AnimalRepository repository;
	
	Controllers(AnimalRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Heloo Modafoca!";
	}
	
	@GetMapping("/")
	public String root() {
		return "This is the root!";
	}
	
	@GetMapping("/animais")
	public ResponseEntity<List<Animal>> getAllAnimais(@RequestParam(required = false) String title) {
		List<Animal> lista_de_animais = new ArrayList<Animal>();
		repository.findAll().forEach(lista_de_animais::add);
		return new ResponseEntity<>(lista_de_animais, HttpStatus.OK);
	}
	
	@PostMapping("/cadastro")
	Animal cadastroAnimal(@RequestBody Animal newAnimal) {
		return repository.save(newAnimal);
	}
}