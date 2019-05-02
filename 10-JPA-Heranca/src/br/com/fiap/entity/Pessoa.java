package br.com.fiap.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Inheritance(strategy=InheritanceType.JOINED) //Por padrão é Single Table

//Alterar nome da coluna DTYPE
//@DiscriminatorColumn(name="ds_tipo")

@Entity
@SequenceGenerator(name="pessoa",sequenceName="SQ_T_PESSOA",allocationSize=1)
public class Pessoa {

	@Id
	@GeneratedValue(generator="pessoa", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
