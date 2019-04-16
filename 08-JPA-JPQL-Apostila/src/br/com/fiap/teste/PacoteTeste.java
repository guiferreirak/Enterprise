package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteTeste {
	
	private static PacoteDAOImpl pDao;
	private static TransporteDAOImpl tDao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		pDao = new PacoteDAOImpl(em);
		tDao = new TransporteDAOImpl(em);
	}
	
	@Test
	void buscarPorTransporte() {
		Transporte t = tDao.pesquisar(1);
		List<Pacote> lista = pDao.buscarPorTransporte(t);
		
		for (Pacote pacote : lista) {
			assertEquals(t.getId(), pacote.getTransporte().getId());
		}
	}

}
