package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Teste {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		Calendar data = null;
		
		data = new GregorianCalendar(2019, data.AUGUST, 5);
		
		p.setDataNascimento(data);
		System.out.println(p.getDataNascimento().getTime());
		
		
		
	}

}
