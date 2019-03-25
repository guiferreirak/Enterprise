package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA", allocationSize=1)
public class Corrida {
	
	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//1. Motorista
	@ManyToOne
	@JoinColumn(name="cd_motorista")
	private Motorista motorista;
	
	//2. Passageiro
	@ManyToOne
	@JoinColumn(name="cd_passageiro")
	private Passageiro passageiro;
	
	//3. Pagamento
	@OneToOne(mappedBy="corrida")
	private Pagamento pagamento;	
	
	@Column(name="ds_origem", length=150)
	private String origem;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_corrida")
	private Calendar data;
	
	@Column(name="vl_corrida", nullable=false)
	private float valor;

	public Corrida() {
		super();
	}

	public Corrida(String origem, String destino, Calendar data, float valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
		
}
