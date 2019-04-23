package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Corrida> buscarPorData(Calendar inicio, Calendar fim) {
		TypedQuery<Corrida> c = em.createQuery("from Corrida c where c.data between :inicio and :fim", Corrida.class);
		
		c.setParameter("inicio", inicio);
		c.setParameter("fim", fim);
		c.setMaxResults(30);
		
		return c.getResultList();
	}

	@Override
	public List<Corrida> buscarPorMotorista(Motorista m) {
		return em.createQuery("from Corrida c where c.motorista.cnh = :cnh", Corrida.class)
				.setParameter("cnh", m.getCnh())
				.getResultList();
	}

	@Override
	public Long countCorridaPorPassageiro(int id) {
		return em.createQuery("select count(c) from Corrida c where c.passageiro.id = :id", Long.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Corrida> buscarCorridasPorPassageiro(String nome) {
		TypedQuery<Corrida> c = em.createQuery("from Corrida c where c.passageiro.nome like :nome", Corrida.class);
		
		c.setParameter("nome", "%" + nome + "%");
		c.setMaxResults(40);
		
		return c.getResultList();
	}

}
