package model.dao;

import java.util.List;

import model.entities.PRO_Cadastro;

public interface PRO_CadastroDao {


	void insert(PRO_Cadastro obj);
	void update(PRO_Cadastro obj);
	void deleteById(Integer id);
	PRO_Cadastro findById(Integer id);
	List<PRO_Cadastro>findAll();
	
	
}	