package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CASO_TESTE")
@SequenceGenerator(name="casoTeste", sequenceName="SQ_T_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	
	@Id
	@GeneratedValue(generator="casoTeste", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_caso_teste")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cd_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy="casoTeste", cascade=CascadeType.PERSIST)
	private List<ItemTeste> itemTeste = new ArrayList<ItemTeste>();
	
	@Column(name="nm_caso_teste", nullable=false, length=100)
	private String nome;
	
	@Column(name="ds_caso_teste", nullable=false)
	private String descricao;
	
	public void addItem(ItemTeste item) {
		itemTeste.add(item);
		item.setCasoTeste(this);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
