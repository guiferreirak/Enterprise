package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="pessoa", sequenceName="SQ_PESSOA", allocationSize=1)
public class Pessoa {
	
	@Id
	@GeneratedValue(generator="pessoa", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Pessoa(Integer id, String nome, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
