package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// Predicate

		/**
		 * list.removeIf(p -> p.getPrice() >= 100.0);
		 * 
		 * for (Product p : list) { System.out.println(p); }
		 */

		// Consumer
		
		  Consumer<Product> cons = p -> p.setPrice(p.getPrice()* 1.1);
		  
		  list.forEach(cons);
		  
		  list.forEach(System.out::println);
		 

		// Function

		// List<String> names = list.stream().map(p ->
		// p.getName().toUpperCase()).collect(Collectors.toList());

		// names.forEach(System.out::println);

	}
}
