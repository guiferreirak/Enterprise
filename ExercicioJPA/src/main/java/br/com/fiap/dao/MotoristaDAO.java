package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.to.MotoristaTO;

public interface MotoristaDAO {
	
	void cadastrar(MotoristaTO motorista);
	
	void atualizar(MotoristaTO motorista);
	
	void remover(Integer cnh);
	
	MotoristaTO consultar(Integer cnh);
	
	void commit(EntityManager em); 
	
}
