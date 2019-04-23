package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Veiculo> buscarPorAno(int ano) {
		return em.createQuery("from Veiculo v where v.ano >= :ano", Veiculo.class)
				.setParameter("ano", ano)
				.getResultList();
	}

}
