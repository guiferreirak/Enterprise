package br.com.fiap.dao;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws ChaveInexistenteException;
	
	T consultar(K codigo) throws ChaveInexistenteException;
	
	void commit() throws CommitException;
	
}
