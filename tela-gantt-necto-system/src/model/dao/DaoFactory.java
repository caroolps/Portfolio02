package model.dao;

import db.DB;
import model.dao.impl.PRO_CadastroDaoJDBC;
import model.dao.impl.TarefaDaoJDBC;
import model.dao.impl.USE_CadastroDaoJDBC;

public class DaoFactory {
	
	public static TarefaDao createProjetosDao() {
		return new TarefaDaoJDBC(DB.getConnection());
	}

	
	public static PRO_CadastroDao createPRO_CadastroDao() {
		return new PRO_CadastroDaoJDBC(DB.getConnection());
	
		
}	
	
	public static USE_CadastroDao createUSE_CadastroDao() {
		return new USE_CadastroDaoJDBC(DB.getConnection());
	
}	

}