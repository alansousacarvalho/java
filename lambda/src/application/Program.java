package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		// Lista para Predicate, Consumer e Function
		/*
		 * List<Product> list = new ArrayList<>(); list.add(new Product("Tv", 900.00));
		 * list.add(new Product("Mouse", 50.00)); list.add(new Product("Tablet",
		 * 350.50)); list.add(new Product("HD Case", 80.90));
		 */

		// Lista para Stream

		/*
		 * List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		 * 
		 * Stream<Integer> st1 = list.stream().map(x -> x * 10);
		 * System.out.println(Arrays.toString(st1.toArray()));
		 * 
		 * Stream<String> st2 = Stream.of("Maria", "Bob", "Alex");
		 * System.out.println(Arrays.toString(st2.toArray()));
		 * 
		 * Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		 * System.out.println(Arrays.toString(st3.limit(10).toArray()));
		 */

		// Lista para Pipeline

		/*
		 * List<Integer> list = Arrays.asList(3, 4, 5, 10, 7); Stream<Integer> st1 =
		 * list.stream().map(x -> x * 10);
		 * System.out.println(Arrays.toString(st1.toArray()));
		 * 
		 * int sum = list.stream().reduce(0, (x,y) -> x + y);
		 * System.out.println("Sum = " + sum);
		 * 
		 * List<Integer> newList = list.stream() .filter(x -> x % 2 == 0) .map(x -> x*
		 * 10) .collect(Collectors.toList());
		 * 
		 * System.out.println(newList);
		 */

		// Predicate

		/**
		 * list.removeIf(p -> p.getPrice() >= 100.0);
		 * 
		 * for (Product p : list) { System.out.println(p); }
		 */

		// Consumer

		/*
		 * Consumer<Product> cons = p -> p.setPrice(p.getPrice()* 1.1);
		 * 
		 * list.forEach(cons);
		 * 
		 * list.forEach(System.out::println);
		 */

		// Function

		/*
		 * List<String> names = list.stream().map(p ->
		 * p.getName().toUpperCase()).collect(Collectors.toList());
		 * 
		 * names.forEach(System.out::println);
		 */

		// Exercício resolvido 1

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Enter full file path: "); String path = sc.next();
		 * 
		 * try(BufferedReader br = new BufferedReader(new FileReader(path))) { String
		 * line = br.readLine();
		 * 
		 * List<Product> listProd = new ArrayList<>();
		 * 
		 * while(line != null) { String[] fields = line.split(","); listProd.add(new
		 * Product(fields[0], Double.parseDouble(fields[1]))); line = br.readLine(); }
		 * 
		 * double mediaProdutos = listProd.stream() .map(p -> p.getPrice()) .reduce(0.0,
		 * (x,y) -> x + y / listProd.size());
		 * 
		 * System.out.println("Average price: " + String.format("%.2f", mediaProdutos));
		 * 
		 * List<String> prodPrecoAbaixoDaMedia = listProd.stream() .filter(p ->
		 * p.getPrice() < mediaProdutos) .map(p -> p.getName()) .sorted((s1, s2) ->
		 * s2.toUpperCase().compareTo(s1.toUpperCase())) .collect(Collectors.toList());
		 * 
		 * prodPrecoAbaixoDaMedia.forEach(System.out::println);
		 * 
		 * } catch (IOException e) { System.out.println("Erro: " + e); }
		 * 
		 * sc.close();
		 */
		
		// Exercício de fixação
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			List<Employee> list = new ArrayList<>();
			
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
			
			List<String> emails = list.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			Double somaSalarios = list.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", somaSalarios));
			
			
		} catch (IOException e) {
			System.out.println("Erro: " + e);
		}
		
		sc.close();

	}
}
