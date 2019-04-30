package br.com.fiap.heranca.entity;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PessoaFisica extends Pessoa{
	
	private String cpf;

	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
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
