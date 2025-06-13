package application;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("=== TESTE 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		for (Seller obj : listSeller) {
			System.out.println(obj.toString());
		}
		System.out.println("=== TESTE 3: Seller findAll ===");
		listSeller = sellerDao.findAll();
		for (Seller obj : listSeller) {
			System.out.println(obj.toString());
		}
		System.out.println("=== TESTE 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Gab", "gab@gmail.com", LocalDateTime.now() , 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

}
