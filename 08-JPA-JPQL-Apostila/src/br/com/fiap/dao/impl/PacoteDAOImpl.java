package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> pacotes = em.createQuery("from Pacote p where p.transporte = :transporte" , Pacote.class);
		
		pacotes.setParameter("transporte", transporte);
		
		return pacotes.getResultList();
	}

	@Override
	public List<Pacote> buscarPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim", Pacote.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getResultList();
	}

	@Override
	public Double sumPrecoPorTransporte(Transporte t) {
		return em.createNamedQuery("Pacote.sumPrecoPorTransporte", Double.class)
				.setParameter("t", t.getEmpresa())
				.getSingleResult();
	}

}
