package application;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", now, 3000.0, obj);
		System.out.println(obj);
		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}
	
}
