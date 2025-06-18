package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = new Department();
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("=== TESTE 1: Department findById === \n");
		department = departmentDao.findById(3);
		System.out.println(department.toString());
		
		System.out.println("\n=== TESTE 2: Department findAll === \n");
		List<Department> depList = new ArrayList<>();
		depList = departmentDao.findAll();
		depList.forEach(dep -> {
			System.out.println(dep.toString());
		});
		
		System.out.println("\n=== TESTE 3: Department insert === \n");
		Department department2 = new Department(null, "Music");
		departmentDao.insert(department2);
		System.out.println("Insert!");
		
		System.out.println("\n=== TESTE 4: Department update === \n");
		department = departmentDao.findById(6);
		department.setName("Games");
		departmentDao.update(department);
		
		System.out.println("Updated!");
		
		System.out.println("\n=== TESTE 5: Department delete === \n");
		
		System.out.print("Digite o ID de qual departamento deseja excluir: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		
		System.out.println("Excluído!");
	}
}
