package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.impl.MusicaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Musica;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

class MusicaDAOTeste {
	
	private static MusicaDAOImpl dao;
	private Musica m;
	
	//Método static que será executado antes de todos os testes
	@BeforeAll
	public static void init() {
		// Arrange - instanciar os objetos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
		EntityManager em = emf.createEntityManager();
		dao = new MusicaDAOImpl(em);
	}
	
	//Método que será executado antes de cada teste
	@BeforeEach
	public void antesDosTestes() {
		// Arrange - instanciar os objetos
		m = new Musica("Teste", 4, Genero.AXE);

		// Act - chamar o método que será testado
		try {
			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na inserção de dado");
		}
	}
	
	@Test
	void atualizar() {	
		//Passando um valor de atualização
		m.setTipo(Genero.FORRO);
		
		//Atualizar
		try {
			dao.atualizar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha ao commitar atualização");
		}
		
		//Buscar
		try {
			Musica musica = dao.consultar(m.getCodigo());
			assertEquals(Genero.FORRO, musica.getTipo());
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			fail("Falha na busca");
		}
	}
	
	@Test
	void remover() {		
		try {
			Musica musica = dao.consultar(m.getCodigo());
			dao.remover(musica.getCodigo());
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha na busca");
		}
		
		assertThrows(ChaveInexistenteException.class, ()-> dao.consultar(m.getCodigo()));
	}
	
	@Test
	void buscar() {		
		try {
			Musica musica = dao.consultar(m.getCodigo());
			// Assert - validação do resultado
			assertNotNull(musica);
			assertEquals("Teste", musica.getNome());
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			fail("Falha na busca");
		}
	}

	@Test
	void cadastrar() {
		// Assert - validação do resultado
		// valida se a sequence gerou um código
		assertNotEquals(0, m.getCodigo());
	}

}
