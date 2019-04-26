package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(VisitaPK.class)
public class Visita {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_local")
	private Local local;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private int classificacao;
	
	public Visita() {
		super();
	}
	
	public Visita(Local local, Pessoa pessoa, Calendar data, int classificacao) {
		super();
		this.local = local;
		this.pessoa = pessoa;
		this.data = data;
		this.classificacao = classificacao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
}
