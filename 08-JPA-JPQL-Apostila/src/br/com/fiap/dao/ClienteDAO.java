package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> listarClientes();
	
	List<Cliente> buscarClienteNome(String nome);
	
	List<Cliente> buscarClienteEstado(String uf);
	
	List<Cliente> buscarClienteReserva(Integer numeroDias);
	
}
