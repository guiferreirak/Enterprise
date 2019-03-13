package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.impl.PassageiroDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TestePassageiro {
		
	@Test
	void cadastrar() {
		
		//Arrange - objetos
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		Passageiro p = new Passageiro("Guilherme", new GregorianCalendar(2000, Calendar.OCTOBER, 21), Genero.MASCULINO);
		PassageiroDAOImpl dao = new PassageiroDAOImpl(em);
		
		//Act - método
		try {
			dao.cadastrar(p);
			dao.commit();
			
			//Assert - validação
			assertNotEquals(0, p.getId());
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na inserção do Passageiro");
		}
		
	}

}
