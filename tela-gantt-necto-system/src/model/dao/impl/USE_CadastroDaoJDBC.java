package model.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.USE_CadastroDao;
import model.entities.USE_Cadastro;

public class USE_CadastroDaoJDBC implements USE_CadastroDao {

	private Connection conn;
	
	public USE_CadastroDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<USE_Cadastro> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM user");
				rs = st.executeQuery();
				
			List<USE_Cadastro> list = new ArrayList<>();
			
			
			while (rs.next()) {
				
				while (rs.next()) {
					USE_Cadastro obj = new USE_Cadastro();
					obj.setId(rs.getInt("Id"));
					obj.setUse_nome(rs.getString("use_nome"));
					obj.setUse_sobrenome(rs.getString("use_sobrenome"));
					obj.setUse_departamento(rs.getString("use_departamento"));
					obj.setUse_estag_efetivo(rs.getString("use_estag_efetivo"));
					obj.setUse_horas_usuario(rs.getString("use_horas_usuario"));

					list.add(obj);
				}
				return list;
			
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
		
		
	}
	
	@Override
	public void insert(USE_Cadastro obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO user "
					+ "(use_nome, use_sobrenome, use_departamento, use_estag_efetivo, use_horas_usuario) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getUse_nome());
			st.setString(2, obj.getUse_sobrenome());
			st.setString(3, obj.getUse_departamento());
			st.setString(4, obj.getUse_estag_efetivo());
			st.setString(5, obj.getUse_horas_usuario());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	
	
		}
	
		@Override
		public void update(USE_Cadastro obj) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(
						"UPDATE user "
						+ "SET use_nome = ?, use_sobrenome = ?, use_departamento = ?, use_estag_efetivo = ?, use_horas_usuario = ?"
						+ "WHERE Id = ?");
				
				st.setString(1, obj.getUse_nome());
				st.setString(2, obj.getUse_sobrenome());
				st.setString(3, obj.getUse_departamento());
				st.setString(4, obj.getUse_estag_efetivo());
				st.setString(5, obj.getUse_horas_usuario());

				
				st.setInt(6, obj.getId());
				
				st.executeUpdate();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}

	
	
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM user WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}


	@Override
	public USE_Cadastro findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM user WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				USE_Cadastro obj = new USE_Cadastro();
				obj.setId(rs.getInt("Id"));
				obj.setUse_nome(rs.getString("use_nome"));
				obj.setUse_sobrenome(rs.getString("use_sobrenome"));
				obj.setUse_departamento(rs.getString("use_departamento"));
				obj.setUse_estag_efetivo(rs.getString("use_estag_efetivo"));
				obj.setUse_horas_usuario(rs.getString("use_horas_usuario"));


				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	
	
	}

}
	
	
	