package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.exercicio.entity.Consulta;
import br.com.fiap.exercicio.entity.ConsultaPK;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPK> implements ConsultaDAO {

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}

}
