package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K>{
	
	protected EntityManager em;
	
	//Reconhecendo que o <T> será um objeto
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
	public void remover(K chave) throws ChaveInexistenteException {
		T objeto = em.find(clazz, chave);
		em.remove(objeto);
	}

	@Override
	public T consultar(K chave) throws ChaveInexistenteException {
		T objeto = em.find(clazz, chave);
		if(objeto == null)
			throw new ChaveInexistenteException("Nada retornado na operação de SELECT");
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
			throw new CommitException("Falha no commit");
		}
	}

}
