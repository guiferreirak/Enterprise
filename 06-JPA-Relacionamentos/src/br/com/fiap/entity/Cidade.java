package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CIDADE")
@SequenceGenerator(name="cidade", sequenceName="SQ_T_CIDADE", allocationSize=1)
public class Cidade {
	
	@Id
	@GeneratedValue(generator="cidade", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_cidade")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_estado")
	private Estado estado;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_CIDADE_RIO", joinColumns = @JoinColumn(name="cd_cidade"), 
									inverseJoinColumns = @JoinColumn(name="cd_rio"))	
	private List<Rios> rios;
	
	@Column(name="nm_cidade")
	private String nome;
	
	@Column(name="nr_pib")
	private double pib;

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

	public double getPib() {
		return pib;
	}

	public void setPib(double pib) {
		this.pib = pib;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Rios> getRios() {
		return rios;
	}

	public void setRios(List<Rios> rios) {
		this.rios = rios;
	}
		
}
