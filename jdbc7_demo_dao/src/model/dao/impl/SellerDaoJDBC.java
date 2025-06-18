package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection con;

	public SellerDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Seller obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("INSERT INTO seller " + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setTimestamp(3, Timestamp.valueOf(obj.getBirthDate()));
			ps.setDouble(4, obj.getBaseSalary());
			ps.setInt(5, obj.getDepartment().getId());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs1 = ps.getGeneratedKeys();
				if (rs1.next()) {
					int id = rs1.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs1);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeStatement(ps);
		}

	}

	@Override
	public void update(Seller obj) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " + "WHERE Id = ?");

			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setTimestamp(3, Timestamp.valueOf(obj.getBirthDate()));
			ps.setDouble(4, obj.getBaseSalary());
			ps.setInt(5, obj.getDepartment().getId());
			ps.setInt(6, obj.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeStatement(ps);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM seller WHERE Id = ? ");

			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			ps.setInt(1, 3);
			rs = ps.executeQuery();
			Seller seller = new Seller();
			if (rs.next()) {
				Department dep = instantiateDeparment(rs);
				seller = instantiateSeller(rs, dep);
				return seller;
			}
			return seller;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(dep);
		return seller;
	}

	private Department instantiateDeparment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "ORDER BY Name");

			rs = ps.executeQuery();
			Seller seller = new Seller();
			List<Seller> listSeller = new ArrayList<>();
			Map<Integer, Department> mapDep = new HashMap<>();
			while (rs.next()) {
				Department dep = mapDep.get(rs.getInt("DepartmentId"));
				if (dep == null) {
					dep = instantiateDeparment(rs);
				}
				seller = instantiateSeller(rs, dep);
				listSeller.add(seller);
			}
			return listSeller;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE DepartmentId = ? " + "ORDER BY Name");

			ps.setInt(1, department.getId());
			rs = ps.executeQuery();
			Seller seller = new Seller();
			List<Seller> listSeller = new ArrayList<>();
			Map<Integer, Department> mapDep = new HashMap<>();
			while (rs.next()) {
				Department dep = mapDep.get(rs.getInt("DepartmentId"));
				if (dep == null) {
					dep = instantiateDeparment(rs);
				}
				seller = instantiateSeller(rs, dep);
				listSeller.add(seller);
			}
			return listSeller;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

}
