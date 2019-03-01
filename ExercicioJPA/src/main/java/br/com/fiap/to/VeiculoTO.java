package br.com.fiap.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName="SQ_T_VEICULO", allocationSize=1)
public class VeiculoTO {
	
	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(generator="veiculo", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="ds_placa", nullable=false, length=9)
	private String placa;
	
	@Column(name="ds_cor", nullable=false, length=20)
	private String cor;
	
	@Column(name="nr_ano")
	private Integer ano;

	public VeiculoTO() {
		super();
	}

	public VeiculoTO(String placa, String cor, Integer ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	
}
