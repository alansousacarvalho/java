package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
	public static void main(String[] args) {
		// Lista para Predicate, Consumer e Function
		/*
		 * List<Product> list = new ArrayList<>(); list.add(new Product("Tv", 900.00));
		 * list.add(new Product("Mouse", 50.00)); list.add(new Product("Tablet",
		 * 350.50)); list.add(new Product("HD Case", 80.90));
		 */

		// Lista para Stream

		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<String> st2 = Stream.of("Maria", "Bob", "Alex");
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));

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

		// Stream

	}
}
