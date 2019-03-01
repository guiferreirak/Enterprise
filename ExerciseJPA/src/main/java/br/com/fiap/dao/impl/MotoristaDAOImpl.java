package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.to.MotoristaTO;

public class MotoristaDAOImpl implements MotoristaDAO{
	
	private EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(MotoristaTO motorista) {
		em.persist(motorista);
	}

	public void atualizar(MotoristaTO motorista) {
		em.merge(motorista);
	}

	public void remover(Integer cnh) throws ChaveInexistenteException {
		MotoristaTO motorista = consultar(cnh);
		em.remove(motorista);
	}

	public MotoristaTO consultar(Integer cnh) throws ChaveInexistenteException{
		MotoristaTO motorista = null;
		try {
			motorista = em.find(MotoristaTO.class, cnh);
			if (motorista == null) {
				throw new ChaveInexistenteException("Nada retornado do banco");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ChaveInexistenteException("Não foi possível realizar a operação de SELECT");
		}
		return motorista;
	}

	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException("Falha ao commitar as operações");
		}
	}
	
}
