package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CapitalDAO;
import br.com.fiap.dao.EstadoDAO;
import br.com.fiap.dao.impl.CapitalDAOImpl;
import br.com.fiap.dao.impl.EstadoDAOImpl;
import br.com.fiap.entity.Capital;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Rios;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class EstadoTeste {
	
	private static EstadoDAO estadoDao;
	private static CapitalDAO capitalDao;
	
	@BeforeAll
	public static void init() {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		estadoDao = new EstadoDAOImpl(em);
		capitalDao = new CapitalDAOImpl(em);
	}
	
	@Test
	void test() {
		//Cadastrar o estado e a capital
		Estado estado = new Estado("Mato Grosso", "MT");
		Capital capital = new Capital(estado, "Cuiabá", 5000);
		
		Cidade c1 = new Cidade();
		c1.setNome("Cidade 1");
		
		Cidade c2 = new Cidade();
		c2.setNome("Cidade 2");
		
		estado.addCidade(c1);
		estado.addCidade(c2);
		
		Rios rio1 = new Rios("Rio Negro", 500);
		Rios rio2 = new Rios("Solimoes", 1500);
		
		List<Rios> rios = new ArrayList<Rios>();
		rios.add(rio1);
		rios.add(rio2);
		
		c1.setRios(rios);
		
		try {
			estadoDao.cadastrar(estado);
			capitalDao.cadastrar(capital);
			capitalDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		
		assertNotEquals(0, estado.getCodigo());
		assertNotEquals(0, capital.getCodigo());
		
		//Buscar a capital cadastrada
		try {
			Capital c = capitalDao.consultar(capital.getCodigo());
			
			assertNotNull(c);
			assertNotNull(c.getEstado());
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

}
