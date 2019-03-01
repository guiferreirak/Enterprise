package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.to.VeiculoTO;

public class TesteVeiculo {

	public static void main(String[] args) {
			
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		VeiculoDAOImpl dao = new VeiculoDAOImpl(em);
		VeiculoTO veiculo = null;
		
		try {
			veiculo = dao.consultar(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Cor: " + veiculo.getCor() + " Placa: " + veiculo.getPlaca());

	}

}
