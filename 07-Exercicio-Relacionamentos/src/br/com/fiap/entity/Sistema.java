package br.com.fiap.entity;

import java.util.List;

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
	
	@OneToMany(mappedBy="sistema")
	private List<CasoTeste> casoTeste;
	
	@Column(name="nm_sistema", length=60, nullable=false)
	private String nome;
	
}
