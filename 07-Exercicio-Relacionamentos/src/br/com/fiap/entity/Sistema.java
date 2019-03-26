package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="nm_sistema", length=60, nullable=false)
	private String nome;
	
}
