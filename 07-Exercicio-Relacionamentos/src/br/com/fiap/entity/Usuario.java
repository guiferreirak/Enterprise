package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO", allocationSize=1)
public class Usuario {
	
	@Id
	@GeneratedValue(generator="usuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private Integer id;
	
	@ManyToMany(mappedBy="usuario")
	private List<ItemTeste> itemTeste;
	
	@Column(name="nm_usuario", nullable=false, length=60)
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ItemTeste> getItemTeste() {
		return itemTeste;
	}

	public void setItemTeste(List<ItemTeste> itemTeste) {
		this.itemTeste = itemTeste;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
