package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.impl.MusicaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Musica;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

class MusicaDAOTeste {

	@Test
	void buscar() {

		// Arrange - instanciar os objetos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
		EntityManager em = emf.createEntityManager();
		MusicaDAOImpl dao = new MusicaDAOImpl(em);
		Musica m = new Musica("Teste", 4, Genero.AXE);

		// Act - chamar o método que será testado
		try {
			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na inserção de dado");
		}
		
		try {
			Musica musica = dao.consultar(m.getCodigo());
			// Assert - validação do resultado
			assertNotNull(musica);
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			fail("Falha na busca");
		}
	}

	@Test
	void cadastrar() {

		// Arrange - instanciar os objetos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
		EntityManager em = emf.createEntityManager();
		MusicaDAOImpl dao = new MusicaDAOImpl(em);
		Musica m = new Musica("Teste", 4, Genero.AXE);

		// Act - chamar o método que será testado
		try {
			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na inserção de dado");
		}

		// Assert - validação do resultado
		// valida se a sequence gerou um código
		assertNotEquals(0, m.getCodigo());
	}

}
