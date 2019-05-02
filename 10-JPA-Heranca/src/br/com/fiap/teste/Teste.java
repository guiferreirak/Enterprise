package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {
	
	private static PessoaDAO dao;
	
	@BeforeAll
	public static void init() {
		dao = new PessoaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	void test() {
		
		Pessoa p = new Pessoa("Carlos");
		PessoaFisica pf = new PessoaFisica("Adalton","333.564.478.98", Calendar.getInstance());
		PessoaJuridica pj = new PessoaJuridica("MC Donalds","454454841218", Calendar.getInstance());
		
		try {
			dao.cadastrar(p);
			dao.cadastrar(pf);
			dao.cadastrar(pj);
			dao.commit();
		} catch (CommitException e) {
			fail("Erro");
			e.printStackTrace();
		}
	}

}
