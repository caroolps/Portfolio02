package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.USE_CadastroDao;
import model.entities.USE_Cadastro;

public class USE_CadastroService {

private USE_CadastroDao dao = DaoFactory.createUSE_CadastroDao();
	
	public List<USE_Cadastro> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(USE_Cadastro obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(USE_Cadastro obj) {
		dao.deleteById(obj.getId());

}}
