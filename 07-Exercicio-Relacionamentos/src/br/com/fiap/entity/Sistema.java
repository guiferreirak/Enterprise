package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_T_SISTEMA", allocationSize=1)
public class Sistema {
	
	@Id
	@GeneratedValue(generator="sistema", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_sistema")
	private Integer id;
	
	@OneToMany(mappedBy="sistema", cascade=CascadeType.PERSIST)
	private List<CasoTeste> casoTeste = new ArrayList<CasoTeste>();
	
	@Column(name="nm_sistema", length=60, nullable=false)
	private String nome;
	
	public void addCaso(CasoTeste caso) {
		casoTeste.add(caso);
		caso.setSistema(this);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CasoTeste> getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(List<CasoTeste> casoTeste) {
		this.casoTeste = casoTeste;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
