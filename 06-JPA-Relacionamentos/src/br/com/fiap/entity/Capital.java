package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CAPITAL")
@SequenceGenerator(name="capital", sequenceName="SQ_T_CAPITAL", allocationSize=1)
public class Capital {
	
	@Id
	@GeneratedValue(generator="capital", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_capital")
	private Integer codigo;
	
	@OneToOne
	@JoinColumn(name="cd_estado", nullable=false)
	private Estado estado;
	
	@Column(name="nm_capital")
	private String nome;
	
	@Column(name="nr_habitantes")
	private Integer numeroHabitantes;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(Integer numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}
	
}
