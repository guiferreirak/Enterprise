package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	//1- Atributo est�tico que ser� �nico
	private static EntityManagerFactory emf;
	
	//2- M�todo est�tico que retorna a �nica inst�ncia..(criar� somente uma vez)
	public static EntityManagerFactory getInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("teste");
		}
		return emf;
	}
	
	//3- Construtor privado
	private EntityManagerFactorySingleton() {}
}
