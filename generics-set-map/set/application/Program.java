package application;

import java.util.Scanner;

import model.entities.Students;

public class Program {
	public static void main(String[] args) {
		//Exercício de Fixação sobre o uso do SET
		Scanner sc = new Scanner(System.in);
		Students student = new Students();
		
		System.out.print("How many students for course A: ");
		Integer qtdeStudentsA = sc.nextInt();
		
		for (int i = 0; i < qtdeStudentsA; i++) {
			System.out.print("Student " + (i + 1) + ": ");
			Integer studentA = sc.nextInt();
			
			student.addStudent(studentA);
		}
		
		System.out.print("How many students for course B: ");
		Integer qtdeStudentsB = sc.nextInt();
		
		for (int i = 0; i < qtdeStudentsB; i++) {
			System.out.print("Student " + (i + 1) + ": ");
			Integer studentB = sc.nextInt();
			student.addStudent(studentB);
		}
		
		System.out.print("How many students for course C: ");
		Integer qtdeStudentsC = sc.nextInt();
		
		for (int i = 0; i < qtdeStudentsC; i++) {
			System.out.print("Student " + (i + 1) + ": ");
			Integer studentC = sc.nextInt();
			student.addStudent(studentC);
		}

		System.out.println("Total students: " + student.getSetStudents().size());

		sc.close();
	}
}