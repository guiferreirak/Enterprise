package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(ConsultaPK.class)
public class Consulta {
	
	@Id
	@ManyToOne
	private Paciente paciente;
	
	@Id
	@ManyToOne
	private Medico medico;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private String observacoes;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Consulta() {
		super();
	}

	public Consulta(Paciente paciente, Medico medico, Calendar data, String observacoes) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
		this.observacoes = observacoes;
	}
	
}
