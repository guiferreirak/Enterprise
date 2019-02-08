package br.com.fiap.bean;

import java.util.Calendar;

public class Pessoa {
	
	private Calendar dataNascimento;
	private String nome;
	private Genero genero;
	
	public Pessoa(Calendar dataNascimento, String nome, Genero genero) {
		super();
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.genero = genero;
	}
	public Pessoa() {
		super();
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
