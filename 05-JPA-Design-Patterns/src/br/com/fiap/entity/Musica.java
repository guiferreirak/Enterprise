package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_MUSICA")
@SequenceGenerator(name = "musica", sequenceName = "SQ_T_MUSICA", allocationSize = 1)
public class Musica {

	@Id
	@GeneratedValue(generator = "musica", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_musica")
	private int codigo;

	@Column(name = "nm_musica", length = 100, nullable = false)
	private String nome;

	@Column(name = "vl_duracao")
	private float duracao;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipo", length = 20)
	private Genero tipo;

	public Musica() {
		super();
	}

	public Musica(String nome, float duracao, Genero tipo) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.tipo = tipo;
	}

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

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public Genero getTipo() {
		return tipo;
	}

	public void setTipo(Genero tipo) {
		this.tipo = tipo;
	}
	
}
