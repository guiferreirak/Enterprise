package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.to.VeiculoTO;

public interface VeiculoDAO {
	
	void cadastrar(VeiculoTO veiculo);
	
	void atualizar(VeiculoTO veiculo);
	
	void remover(Integer id);
	
	VeiculoTO consultar(Integer id);
	
	void commit(EntityManager em); 
	
}
