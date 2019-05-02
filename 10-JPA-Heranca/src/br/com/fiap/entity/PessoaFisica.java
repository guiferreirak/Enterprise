package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaFisica extends Pessoa {

	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String cpf, Calendar dataNascimento) {
		super(nome);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
