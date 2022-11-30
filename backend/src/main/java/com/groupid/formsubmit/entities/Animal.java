package com.groupid.formsubmit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String raca;
	
	protected Animal() {}
	
	public Animal(String nome, String raca) {
		this.nome = nome;
		this.raca = raca;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Animal[id=%d, nome='%s', raça='%s']",
				id, nome, raca);
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRaca() {
		return raca;
	}
}
