package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> listarClientes();
	
	List<Cliente> buscarClienteNome(String nome);
	
	List<Cliente> buscarClienteEstado(String uf);
	
	List<Cliente> buscarClienteReserva(Integer numeroDias);
	
	//NamedQuery
	List<Cliente> buscar(String nome, String cidade);
	
	//NamedQuery - buscar por uma lista de Estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//NamedQuery - contagem por Estados
	long countPorEstados(String estado);
	
}
