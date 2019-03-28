package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_TESTE")
@SequenceGenerator(name="itemTeste", sequenceName="SQ_T_ITEM_TESTE", allocationSize=1)
public class ItemTeste {
	
	@Id
	@GeneratedValue(generator="itemTeste", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_item_teste")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cd_caso_teste")
	private CasoTeste casoTeste;
	
	@ManyToMany
	@JoinTable(name="T_ITEM_TESTE_USUARIO", joinColumns=@JoinColumn(name="cd_item_teste"),
										    inverseJoinColumns=@JoinColumn(name="cd_usuario"))
	private List<Usuario> usuario;
	
	@Column(name="ds_item_teste", nullable=false, length=100)
	private String descricao;
	
}
