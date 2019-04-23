package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer>{
	
	List<Corrida> buscarPorData(Calendar inicio, Calendar fim);
	
	List<Corrida> buscarPorMotorista(Motorista m);
	
	Long countCorridaPorPassageiro(int id);
	
	List<Corrida> buscarCorridasPorPassageiro(String nome);

}
