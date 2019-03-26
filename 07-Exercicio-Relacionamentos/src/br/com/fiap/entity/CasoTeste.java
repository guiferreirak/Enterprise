package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="nm_caso_teste", nullable=false, length=100)
	private String nome;
	
	@Column(name="ds_caso_teste", nullable=false)
	private String descricao;
	
}
