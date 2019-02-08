package br.com.fiap.bean;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome="T_VEICULO")
public class Veiculo {
	
	@Coluna(nome="vl_preco", tipo="NUMBER")
	private String cor;
	
	@Coluna(nome="ds_fabricante", tipo="VARCHAR")
	private String fabricante;
	
	@Coluna(nome="ds_cor", tipo="VARCHAR", tamanho=50)
	private double preco;
	
	public void andar() {
		
	}
	
	
}
