package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista,Integer> implements MotoristaDAO{

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Motorista> buscarPornome(String nome) {
		TypedQuery<Motorista> m = em.createQuery("from Motorista m where m.nome like :nome", Motorista.class);
		
		m.setParameter("nome", "%" + nome + "%");
		m.setMaxResults(50);
		
		return m.getResultList();
	}
	

}
