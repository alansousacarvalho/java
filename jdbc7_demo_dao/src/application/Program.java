package application;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);

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
		Seller newSeller = new Seller(null, "Gab", "gab@gmail.com", LocalDateTime.parse("1990-04-12T15:30"), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=== TESTE 5: Seller update ===");
		seller = sellerDao.findById(12);
		seller.setBirthDate(LocalDateTime.parse("1990-04-12T15:30"));
		seller.setName("Ana Beatriz");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("=== TESTE 5: Seller delete ===");
		
		System.out.print("Enter id for delete test: ");
		int idSeller = sc.nextInt();
		
		sellerDao.deleteById(idSeller);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
