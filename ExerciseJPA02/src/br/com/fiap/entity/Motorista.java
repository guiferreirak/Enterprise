package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista {
	
	@Id
	@Column(name="nr_carteira")
	private Integer cnh;
	
	@OneToMany(mappedBy="motorista", cascade=CascadeType.ALL)
	private List<Corrida> corrida = new ArrayList<Corrida>();
	
	@ManyToMany(mappedBy="motorista")
	private List<Veiculo> veiculo;
	
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="ft_carteira")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;

	public Motorista() {
		super();
	}

	public Motorista(Integer cnh, String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		this.cnh = cnh;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
	}
	
	public Motorista(List<Corrida> corrida, Integer cnh, String nome, Calendar dataNascimento, byte[] foto,
			Genero genero) {
		super();
		this.corrida = corrida;
		this.cnh = cnh;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public void addCorrida(Corrida c) {
		corrida.add(c);
		c.setMotorista(this);
	}
	
	public Integer getCnh() {
		return cnh;
	}

	public void setCnh(Integer cnh) {
		this.cnh = cnh;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
