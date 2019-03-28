package br.com.fiap.dao;

import br.com.fiap.exception.ChaveInexistente;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws ChaveInexistente;
	
	T consultar(K codigo) throws ChaveInexistente;
	
	void commit() throws CommitException;
	
}
