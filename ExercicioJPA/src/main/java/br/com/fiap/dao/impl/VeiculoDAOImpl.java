package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.to.VeiculoTO;

public class VeiculoDAOImpl implements VeiculoDAO {
	
	private EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(VeiculoTO veiculo) {
		em.persist(veiculo);
	}

	public void atualizar(VeiculoTO veiculo) {
		em.merge(veiculo);
	}

	public void remover(Integer id) throws ChaveInexistenteException {
		VeiculoTO veiculo = consultar(id);
		em.remove(veiculo);
	}

	public VeiculoTO consultar(Integer id) throws ChaveInexistenteException{
		VeiculoTO veiculo = null;
		try {
			veiculo = em.find(VeiculoTO.class, id);
			if (veiculo == null) {
				throw new ChaveInexistenteException("Nada retornado do banco");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ChaveInexistenteException("Não foi possível realizar a operação de SELECT");
		}
		return veiculo;
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
