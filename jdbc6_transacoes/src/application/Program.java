package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		
		try {
			con = DB.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
//			int x = 1;
//			if(x < 2) {
//				throw new SQLException("Fake error");
//			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			con.commit();
			
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
			
		} catch (Exception e) {
			try {
				con.rollback();
				throw new DbException("Transaction rolled back! Cause by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = DB.getConnection();
			
			st = con.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? " // 'SET' att. valor
					+ "WHERE " // 'Where' é a restrição // Qnd for atualizar, sempre tem que colocar uma restrição.
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate(); // Linhas afetadas
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		*/

	}

}
