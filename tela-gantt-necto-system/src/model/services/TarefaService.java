package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.TarefaDao;
import model.entities.Tarefa;

public class TarefaService {
	
	private TarefaDao dao = DaoFactory.createProjetosDao();
	
	public List<Tarefa> findAll() {
		

		return dao.findAll();
	}
	
	public void saveOrUpdate(Tarefa obj) {
		if(obj.getId()==null) {
			dao.insert(obj);
		}
		
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Tarefa obj) {
		dao.deleteById(obj.getId());
	}

}
