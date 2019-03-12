package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MusicaDAO;
import br.com.fiap.entity.Musica;

public class MusicaDAOImpl extends GenericDAOImpl<Musica, Integer> implements MusicaDAO{

	public MusicaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
		
}
