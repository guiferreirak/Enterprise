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
	void listarClientes() {
		List<Cliente> clientes = dao.listarClientes();
		
		assertNotEquals(0, clientes.size());
	}
	
	@Test
	void buscarClienteNome() {
		List<Cliente> clientes = dao.buscarClienteNome("Le");
		
		for (Cliente cliente : clientes) {
			assertTrue(cliente.getNome().contains("Le"));
		}
	}
	
	@Test
	void buscarClienteEstado() {
		List<Cliente> cliente = dao.buscarClienteEstado("SP");
		for (Cliente c : cliente) {
			assertEquals("SP", c.getEndereco().getCidade().getUf());
		}
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
