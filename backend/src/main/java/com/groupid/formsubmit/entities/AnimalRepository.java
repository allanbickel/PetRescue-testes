package com.groupid.formsubmit.entities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long>{
	
	List<Animal> findByNome(String nome);
	
	List<Animal> findByRaca(String raca);
	
	Animal findById(long id);
}
