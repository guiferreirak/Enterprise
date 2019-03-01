package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.to.VeiculoTO;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = emf.createEntityManager();
		
		VeiculoDAOImpl dao = new VeiculoDAOImpl(em);
		VeiculoTO veiculo = new VeiculoTO("FOX6844", "Vermelho", 1994);
		
		try {
			dao.cadastrar(veiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Veiculo cadastrado");

	}

}
