package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_T_PASSAGEIRO", allocationSize=1)
public class Passageiro {
	
	@Id
	@Column(name="cd_passageiro")
	@GeneratedValue(generator="passageiro", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="nm_passageiro", length=100, nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="passageiro", cascade=CascadeType.PERSIST)
	private List<Corrida> corrida = new ArrayList<Corrida>();
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	public Passageiro() {
		super();
	}

	public Passageiro(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}
	
	public Passageiro(String nome, List<Corrida> corrida, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.corrida = corrida;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}
	
	public void addCorrida(Corrida c) {
		corrida.add(c);
		c.setPassageiro(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public List<Corrida> getCorrida() {
		return corrida;
	}

	public void setCorrida(List<Corrida> corrida) {
		this.corrida = corrida;
	}
		
}
