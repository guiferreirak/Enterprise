package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ESTADO")
@SequenceGenerator(name="estado", sequenceName="SQ_T_ESTADO", allocationSize=1)
public class Estado {
	
	@Id
	@GeneratedValue(generator="estado", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_estado")
	private Integer codigo;
	
	//mappedBy -> nome do attr que mapeia a FK na classe Capital
	@OneToOne(mappedBy="estado")
	private Capital capital;
	
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;
	
	@Column(name="nm_estado")
	private String nome;
	
	@Column(name="ds_sigla", length=2)
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
