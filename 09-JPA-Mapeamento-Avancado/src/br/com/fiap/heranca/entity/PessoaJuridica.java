package br.com.fiap.heranca.entity;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataAbertura;

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
