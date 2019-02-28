package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {
	
	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T objeto) {
		em.persist(objeto);		
	}

	@Override
	public void atualizar(T objeto) {
		em.merge(objeto);
	}

	@Override
	public void remover(K codigo) throws ChaveInexistenteException {
		T objeto = consultar(codigo);
		em.remove(objeto);
	}

	@Override
	public T consultar(K codigo) throws ChaveInexistenteException {
		T objeto = em.find(clazz, codigo);
		if (objeto == null) {
			throw new ChaveInexistenteException();
		}
		return objeto;
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
}
