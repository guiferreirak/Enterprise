package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listarClientes() {
		//Criar a typed query
		TypedQuery<Cliente> clientes = em.createQuery("from Cliente", Cliente.class);
		clientes.setMaxResults(10); //Maximo de 10 resultados
		
		//Executar
		return clientes.getResultList();
	}
	
	//Comparando os nomes e deixando tudo minúsculo
	@Override
	public List<Cliente> buscarClienteNome(String nome) {
		TypedQuery<Cliente> clientes = em.createQuery("from Cliente c where lower(c.nome) like lower(:nome) order by c.nome", Cliente.class);
		
		clientes.setParameter("nome", "%" + nome + "%");
		
		return clientes.getResultList();
	}

	@Override
	public List<Cliente> buscarClienteEstado(String uf) {
		TypedQuery<Cliente> clientes = em.createQuery("from Cliente c where c.endereco.cidade.uf = :uf", Cliente.class);
		
		clientes.setParameter("uf", uf);
		
		return clientes.getResultList();
	}

	@Override
	public List<Cliente> buscarClienteReserva(Integer numeroDias) {
		TypedQuery<Cliente> clientes = em.createQuery("select cliente from Reserva r "
													+ "	where r.numeroDias = :numeroDias", Cliente.class);
		
		clientes.setParameter("numeroDias", numeroDias);
		
		return clientes.getResultList();
	}
	
	//NamedQuery
	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createNamedQuery("Cliente.porNome", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("c", "%" + cidade + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {		
		return em.createNamedQuery("Cliente.porEstados", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	@Override
	public long countPorEstados(String estado) {
		return em.createNamedQuery("Cliente.countPorEstados", Long.class)
				.setParameter("e", estado)
				.getSingleResult();
	}

}
