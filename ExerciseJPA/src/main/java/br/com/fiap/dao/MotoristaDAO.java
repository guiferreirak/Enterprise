package br.com.fiap.dao;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.to.MotoristaTO;

public interface MotoristaDAO {
	
	void cadastrar(MotoristaTO motorista);
	
	void atualizar(MotoristaTO motorista);
	
	void remover(Integer cnh) throws ChaveInexistenteException;
	
	MotoristaTO consultar(Integer cnh) throws ChaveInexistenteException;
	
	void commit() throws CommitException; 
	
}
