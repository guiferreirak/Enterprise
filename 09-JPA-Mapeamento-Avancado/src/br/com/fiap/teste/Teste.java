package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.VisitaDAO;
import br.com.fiap.dao.impl.VisitaDAOImpl;
import br.com.fiap.entity.Local;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.Visita;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {
	
	private static VisitaDAO dao;
	
	@BeforeAll
	static void init() {
		dao = new VisitaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	void cadastrarTudo() {
		Local l = new Local("Bahia", "Av. Salvador");
		Pessoa p = new Pessoa("Rogerio", new GregorianCalendar(1990, Calendar.OCTOBER, 2));
		Visita v = new Visita(l, p, Calendar.getInstance(), 2);
		
		try {
			dao.cadastrar(v);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
