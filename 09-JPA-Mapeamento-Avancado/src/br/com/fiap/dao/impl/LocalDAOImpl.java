package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LocalDAO;
import br.com.fiap.entity.Local;

public class LocalDAOImpl extends GenericDAOImpl<Local, Integer> implements LocalDAO{

	public LocalDAOImpl(EntityManager em) {
		super(em);
	}

}
