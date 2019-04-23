package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.entity.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer> implements PassageiroDAO {

	public PassageiroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	//Entidade Pagamento
	@Override
	public Double somaPagamentoPorPassageiro(int id) {
		em.createQuery("select p.corrida.passageiro.nome , sum(p.valor) "
						+ "from Pagamento p where p.corrida.passageiro.id");
		return null;
	}

}
