package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.to.VeiculoTO;

public class VeiculoDAOImpl implements VeiculoDAO {
	
	private EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(VeiculoTO veiculo) {
		em.persist(veiculo);
		commit(em);
	}

	public void atualizar(VeiculoTO veiculo) {
		em.merge(veiculo);
		commit(em);
	}

	public void remover(Integer id) {
		VeiculoTO veiculo = em.find(VeiculoTO.class, id);
		em.remove(veiculo);
	}

	public VeiculoTO consultar(Integer id) {
		VeiculoTO veiculo = em.find(VeiculoTO.class, id);
		return veiculo;
	}

	public void commit(EntityManager em) {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

}
