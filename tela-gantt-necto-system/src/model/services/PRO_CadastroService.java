package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.PRO_CadastroDao;
import model.entities.PRO_Cadastro;

public class PRO_CadastroService {

	
private PRO_CadastroDao dao = DaoFactory.createPRO_CadastroDao();
	
	public List<PRO_Cadastro> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(PRO_Cadastro obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(PRO_Cadastro obj) {
		dao.deleteById(obj.getId());

}}
