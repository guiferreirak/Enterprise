package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Veiculo;

public class Teste {

	public static void main(String[] args) {
		
		Veiculo v = new Veiculo();
		
		//API Reflection - recupera o nome da classe
		String nome = v.getClass().getName();
		System.out.println(nome);
		
		System.out.println();
		
		//Recuperar os métodos da classe
		Method[] m = v.getClass().getDeclaredMethods();
		for(Method metodos: m) {
			System.out.println(metodos);
		}
		
		System.out.println();
		
		//Recuperar os atributos da classe
		Field[] atributo = v.getClass().getDeclaredFields();
		for(Field a: atributo) {
			System.out.println(a.getName());
		}
		System.out.println();
		for(Field a: atributo) {
			Coluna anotacao = a.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
		}
		
	}

}
