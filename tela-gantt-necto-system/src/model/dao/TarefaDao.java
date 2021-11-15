package model.dao;

import java.util.List;

import model.entities.Tarefa;

public interface TarefaDao {

	void insert(Tarefa obj);
	void update(Tarefa obj);
	void deleteById(Integer id);
	Tarefa findById(Integer id);
	List<Tarefa>findAll();
	
	void updateGantt(Tarefa obj);
}	