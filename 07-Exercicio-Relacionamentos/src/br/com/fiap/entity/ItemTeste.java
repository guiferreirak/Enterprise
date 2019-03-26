package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="ds_item_teste", nullable=false, length=100)
	private String descricao;
	
}
