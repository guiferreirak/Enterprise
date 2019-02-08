package br.com.fiap.teste;

import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Veiculo;

public class Exercicio {
	
	public static void main(String[] args) {
		
		Veiculo v = new Veiculo();
		
		//Recuperar a anotação
		Tabela anotacao = v.getClass().getAnnotation(Tabela.class);
		
		System.out.println("SELECT * FROM " + anotacao.nome());
	}
}
