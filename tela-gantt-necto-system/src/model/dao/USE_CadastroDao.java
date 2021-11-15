package model.dao;

import java.util.List;

import model.entities.USE_Cadastro;

public interface USE_CadastroDao {
	
	void insert(USE_Cadastro obj);
	void update(USE_Cadastro obj);
	void deleteById(Integer id);
	USE_Cadastro findById(Integer id);
	List<USE_Cadastro> findAll();
	

}
