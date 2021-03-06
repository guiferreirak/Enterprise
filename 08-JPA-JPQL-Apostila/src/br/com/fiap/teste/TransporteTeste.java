package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Transporte;

class TransporteTeste {
	
	private static TransporteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new TransporteDAOImpl(em);
	}
	
	@Test
	void buscarPorEmpresa() {
		List<Transporte> lista = dao.buscarPorEmpresa("GOL");
		
		assertEquals(1, lista.size());
		
		//validar se o conteudo da lista � o que esperamos
		for (Transporte transporte : lista) {
			assertEquals("GOL", transporte.getEmpresa());
		}
	}
	
	@Test
	void test() {
		List<Transporte> lista = dao.listarTransportes();
		
		assertEquals(3, lista.size());
	}

}
