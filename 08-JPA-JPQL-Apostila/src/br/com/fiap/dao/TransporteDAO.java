package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Transporte;

public interface TransporteDAO extends GenericDAO<Transporte,Integer>{
	
	List<Transporte> listarTransportes();
	
	List<Transporte> buscarPorEmpresa(String nome);
}
