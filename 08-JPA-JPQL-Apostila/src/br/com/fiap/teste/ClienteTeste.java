package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteTeste {
	
	private static ClienteDAOImpl dao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void buscarClienteReserva() {
		List<Cliente> clientes = dao.buscarClienteReserva(10);
		
		assertEquals(2, clientes.size());
		
		for (Cliente cliente : clientes) {
			System.out.println("Cliente: " + cliente.getNome());
		}
	}
}
