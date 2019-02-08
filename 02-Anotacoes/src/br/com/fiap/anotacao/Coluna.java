package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Essa anotação é específica para os atributos da classe (colunas da tabela)
@Target(ElementType.FIELD)

//Manter a anotação até a execuçao
@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {
	
	String nome();
	
	String tipo();
	
	int tamanho() default 255;
	
}
