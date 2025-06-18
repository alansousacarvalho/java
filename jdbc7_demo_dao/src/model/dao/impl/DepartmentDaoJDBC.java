package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	private Connection con;

	public DepartmentDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?) ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getName());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs1 = ps.getGeneratedKeys();
				while (rs1.next()) {
					int id = rs1.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs1);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("UPDATE department "
					+ "SET Name = ?" + "WHERE Id = ?");
			
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("DELETE FROM department "
					+ "WHERE Id = ?");
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department dep = new Department();

		try {
			ps = con.prepareStatement("SELECT * FROM department " + "WHERE Id = ? ");

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				dep = instantiateDepartment(rs);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		return dep;
	}

	public Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt(1));
		dep.setName(rs.getString(2));
		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department dep = new Department();
		List<Department> depList = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM department");
			rs = ps.executeQuery();

			while (rs.next()) {
				dep = instantiateDepartment(rs);
				depList.add(dep);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		return depList;
	}
}
