package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.impl.ConsultaDAOImpl;
import br.com.fiap.dao.impl.MedicoDAOImpl;
import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteMedico {
	
	private static ConsultaDAO dao;
	
	@BeforeAll
	static void init() {
		dao = new ConsultaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	void cadastrarTudo() {
		Medico m = new Medico(449366, "Guilherme", "Ortopedista");
		Paciente p = new Paciente("Bruno");
		Consulta c = new Consulta(p, m, Calendar.getInstance(), "Braço esquerdo fraturado");
		
		try {
			dao.cadastrar(c);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha ao cadastrar em cascata");
		}
	}

}
