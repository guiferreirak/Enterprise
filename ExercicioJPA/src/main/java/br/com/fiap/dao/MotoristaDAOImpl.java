package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.to.MotoristaTO;

public class MotoristaDAOImpl implements MotoristaDAO{
	
	private EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(MotoristaTO motorista) {
		em.persist(motorista);
		commit(em);
	}

	public void atualizar(MotoristaTO motorista) {
		em.merge(motorista);
		commit(em);
	}

	public void remover(Integer cnh) {
		MotoristaTO motorista = em.find(MotoristaTO.class, cnh);
		em.remove(motorista);
	}

	public MotoristaTO consultar(Integer cnh) {
		MotoristaTO motorista = em.find(MotoristaTO.class, cnh);
		return motorista;
	}

	public void commit(EntityManager em) {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
}
