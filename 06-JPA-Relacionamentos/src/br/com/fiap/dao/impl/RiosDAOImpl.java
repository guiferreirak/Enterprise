package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.RiosDAO;
import br.com.fiap.entity.Rios;

public class RiosDAOImpl extends GenericDAOImpl<Rios, Integer> implements RiosDAO{

	public RiosDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
