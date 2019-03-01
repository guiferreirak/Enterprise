package br.com.fiap.dao;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.to.VeiculoTO;

public interface VeiculoDAO {
	
	void cadastrar(VeiculoTO veiculo);
	
	void atualizar(VeiculoTO veiculo);
	
	void remover(Integer id) throws ChaveInexistenteException;
	
	VeiculoTO consultar(Integer id) throws ChaveInexistenteException;
	
	void commit() throws CommitException; 
	
}
