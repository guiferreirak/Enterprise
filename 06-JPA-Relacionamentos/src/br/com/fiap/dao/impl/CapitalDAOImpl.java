package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CapitalDAO;
import br.com.fiap.entity.Capital;

public class CapitalDAOImpl extends GenericDAOImpl<Capital, Integer> implements CapitalDAO {

	public CapitalDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
