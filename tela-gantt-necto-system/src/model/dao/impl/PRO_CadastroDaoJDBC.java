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
import model.dao.PRO_CadastroDao;
import model.entities.PRO_Cadastro;

public class PRO_CadastroDaoJDBC implements PRO_CadastroDao {

	private Connection conn;

	public PRO_CadastroDaoJDBC(Connection conn) {
		this.conn = conn;

	}

	@Override
	public PRO_Cadastro findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pro_cadastro WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				PRO_Cadastro obj = new PRO_Cadastro();
				obj.setId(rs.getInt("Id"));
				obj.setPro_Titulo(rs.getString("pro_Titulo"));
				obj.setPro_Data_Inicio(rs.getString("pro_Data_Inicio"));
				obj.setPro_Data_Final(rs.getString("pro_Data_Final"));
				obj.setPro_Horas(rs.getString("pro_Horas"));
				obj.setPro_Progresso(rs.getString("pro_progresso"));
				obj.setPro_Dep_Posterior(rs.getString("pro_Dep_Posterior"));
				obj.setPro_Cliente(rs.getString("pro_Cliente"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<PRO_Cadastro> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM pro_Cadastro");
			rs = st.executeQuery();
			

			List<PRO_Cadastro> list = new ArrayList<>();

			while (rs.next()) {

				while (rs.next()) {
					PRO_Cadastro obj = new PRO_Cadastro();
					obj.setId(rs.getInt("Id"));
					obj.setPro_Titulo(rs.getString("pro_Titulo"));
					obj.setPro_Data_Inicio(rs.getString("pro_Data_Inicio"));
					obj.setPro_Data_Final(rs.getString("pro_Data_Final"));
					obj.setPro_Horas(rs.getString("pro_Horas"));
					obj.setPro_Progresso(rs.getString("pro_progresso"));
					obj.setPro_Dep_Posterior(rs.getString("pro_Dep_Posterior"));
					obj.setPro_Cliente(rs.getString("pro_Cliente"));

					list.add(obj);
//					System.out.println(obj.getTaskname());

				}

				return list;

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
		return null;

	}

	@Override
	public void insert(PRO_Cadastro obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO pro_cadastro "
					+ "(pro_Titulo, pro_Data_Inicio, pro_Data_Final, pro_Horas, pro_progresso, pro_Dep_Posterior, pro_Cliente) "
					+ "VALUES " + "(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getPro_Titulo());
			st.setString(2, obj.getPro_Data_Inicio());
			st.setString(3, obj.getPro_Data_Final());
			st.setString(4, obj.getPro_Horas());
			st.setString(5, obj.getPro_Progresso());
			st.setString(6, obj.getPro_Dep_Posterior());
			st.setString(7, obj.getPro_Cliente());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(PRO_Cadastro obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE pro_cadastro "
					+ "SET pro_Titulo = ?, pro_Data_Inicio = ?, pro_Data_Final = ?, pro_Horas = ?, pro_progresso = ?, pro_Dep_Posterior = ?, pro_Cliente = ? "
					+ "WHERE Id = ?");

			st.setString(1, obj.getPro_Titulo());
			st.setString(2, obj.getPro_Data_Inicio());
			st.setString(3, obj.getPro_Data_Final());
			st.setString(4, obj.getPro_Horas());
			st.setString(5, obj.getPro_Progresso());
			st.setString(6, obj.getPro_Dep_Posterior());
			st.setString(7, obj.getPro_Cliente());

			st.setInt(8, obj.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override

	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM pro_cadastro WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}
}