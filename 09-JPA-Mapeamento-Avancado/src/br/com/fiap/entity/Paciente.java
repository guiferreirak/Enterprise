package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="paciente", sequenceName="SQ_PACIENTE", allocationSize=1)
public class Paciente {
	
	@Id
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Paciente() {
		super();
	}

	public Paciente(String nome) {
		super();
		this.nome = nome;
	}
	
}
