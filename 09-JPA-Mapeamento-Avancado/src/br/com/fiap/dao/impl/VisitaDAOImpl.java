package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VisitaDAO;
import br.com.fiap.entity.Visita;
import br.com.fiap.entity.VisitaPK;

public class VisitaDAOImpl extends GenericDAOImpl<Visita, VisitaPK> implements VisitaDAO{

	public VisitaDAOImpl(EntityManager em) {
		super(em);
	}

}
