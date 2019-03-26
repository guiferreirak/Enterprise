package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO", allocationSize=1)
public class Usuario {
	
	@Id
	@GeneratedValue(generator="usuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private Integer id;
	
	@Column(name="nm_usuario", nullable=false, length=60)
	private String nome;
	
}
