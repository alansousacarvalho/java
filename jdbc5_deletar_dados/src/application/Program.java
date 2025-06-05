package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = DB.getConnection();
			st = con.prepareStatement(
					"DELETE FROM department " // Deletar 
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 2);
		
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (Exception e) {
			throw new DbIntegrityException(e.getMessage());
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
