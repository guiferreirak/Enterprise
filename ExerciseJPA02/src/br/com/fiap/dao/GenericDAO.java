package br.com.fiap.dao;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T objeto);
	
	void atualizar(T objeto);
	
	void remover(K chave) throws ChaveInexistenteException;	
	
	T consultar(K chave) throws ChaveInexistenteException;
	
	void commit() throws CommitException;
	
}
