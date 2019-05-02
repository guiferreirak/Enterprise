package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataAbertura;

	public PessoaJuridica(String cnpj, Calendar dataAbertura) {
		super();
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
	}

	public PessoaJuridica(String nome, String cnpj, Calendar dataAbertura) {
		super(nome);
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
	}

	public PessoaJuridica() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
}
