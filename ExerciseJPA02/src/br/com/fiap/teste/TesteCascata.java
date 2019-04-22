package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.impl.PassageiroDAOImpl;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteCascata {

	@SuppressWarnings("all")
	@Test
	void test() {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PassageiroDAOImpl dao = new PassageiroDAOImpl(em);
		
		//Passageiro
		Passageiro p = new Passageiro("Gui", new GregorianCalendar(2000, Calendar.OCTOBER, 21), Genero.MASCULINO);
		
		//Motoristas
		Motorista m1 = new Motorista(123456789, "Robson", new GregorianCalendar(1974, Calendar.APRIL, 13), null, Genero.MASCULINO);
		
		//Corridas
		Corrida c1 = new Corrida("Vila Mariana - SP", "Faria Lima - SP", 
								new GregorianCalendar(2019, Calendar.OCTOBER, 23), 25.50f);
				
		//Pagamento
		Pagamento pgto1 = new Pagamento(c1, new GregorianCalendar(2019, Calendar.OCTOBER, 23), 25.50f, FormaPagamento.DINHEIRO);
		
		//Veiculo
		Veiculo v1 = new Veiculo("FDR7295", "Amarelo", 1998);
		
		p.addCorrida(c1);
		
		m1.addCorrida(c1);
		
		c1.setPagamento(pgto1);
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(v1);
		
		List<Motorista> motoristas = new ArrayList<Motorista>();
		motoristas.add(m1);
		
		m1.setVeiculo(veiculos);
		v1.setMotorista(motoristas);
						
		try {
			dao.cadastrar(p);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha na inserção em cascata");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
