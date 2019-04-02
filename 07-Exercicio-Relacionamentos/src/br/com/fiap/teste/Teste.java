package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.impl.SistemaDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	@Test
	void test() {
		SistemaDAOImpl dao = new SistemaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		//Sistema possui vinculo ao Caso de Teste
		Sistema sistema = new Sistema();
		sistema.setNome("Sistema do rei do gado");
		
		CasoTeste caso = new CasoTeste();
		caso.setNome("Contagem de gado");
		caso.setDescricao("Contagem de gado através do IOT");
		
		ItemTeste item1 = new ItemTeste();
		item1.setDescricao("Contar um rebanho com 100 cabeças");
		
		ItemTeste item2 = new ItemTeste();
		item2.setDescricao("Contar um rebanho por m2");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Juninho");
		
		sistema.addCaso(caso);
		
		caso.addItem(item1);
		caso.addItem(item2);
		
		//Criamos uma lista pois na classe Item possuimos um attrb lista de usuários
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
		item1.setUsuario(usuarios);
		
		try {
			dao.cadastrar(sistema);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
				
	}

}
