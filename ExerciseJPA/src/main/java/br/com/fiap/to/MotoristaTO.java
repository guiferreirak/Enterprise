package br.com.fiap.to;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class MotoristaTO {
	
	@Id
	@Column(name="nr_carteira")
	private Integer cnh;
	
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

	public MotoristaTO() {
		super();
	}

	public MotoristaTO(Integer cnh, String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		this.cnh = cnh;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
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
	
	
}
