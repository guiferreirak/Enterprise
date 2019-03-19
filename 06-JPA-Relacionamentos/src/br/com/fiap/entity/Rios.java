package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RIO")
@SequenceGenerator(name="rio", sequenceName="SQ_T_RIO", allocationSize=1)
public class Rios {
	
	@Id
	@GeneratedValue(generator="rio", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_rio")
	private Integer codigo;
	
	@Column(name="nm_rio")
	private String nome;
	
	@Column(name="nr_extensao")
	private float extensao;

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

	public float getExtensao() {
		return extensao;
	}

	public void setExtensao(float extensao) {
		this.extensao = extensao;
	}
		
}
