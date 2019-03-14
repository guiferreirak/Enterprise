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
	
	//M�todo static que ser� executado antes de todos os testes
	@BeforeAll
	public static void init() {
		// Arrange - instanciar os objetos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
		EntityManager em = emf.createEntityManager();
		dao = new MusicaDAOImpl(em);
	}
	
	//M�todo que ser� executado antes de cada teste
	@BeforeEach
	public void antesDosTestes() {
		// Arrange - instanciar os objetos
		m = new Musica("Teste", 4, Genero.AXE);

		// Act - chamar o m�todo que ser� testado
		try {
			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na inser��o de dado");
		}
	}
	
	@Test
	void atualizar() {	
		//Passando um valor de atualiza��o
		m.setTipo(Genero.FORRO);
		
		//Atualizar
		try {
			dao.atualizar(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha ao commitar atualiza��o");
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
			// Assert - valida��o do resultado
			assertNotNull(musica);
			assertEquals("Teste", musica.getNome());
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			fail("Falha na busca");
		}
	}

	@Test
	void cadastrar() {
		// Assert - valida��o do resultado
		// valida se a sequence gerou um c�digo
		assertNotEquals(0, m.getCodigo());
	}

}
