package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		// Aula sobre o MAP
		// Exemplo 1:
		/**
		 * Map<String, String> cookies = new TreeMap<>();
		 * 
		 * // Add. cookies.put("username", "Maria"); cookies.put("email",
		 * "maria@gmail.com"); cookies.put("phone", "(61) 99711-1222");
		 * 
		 * // Remover cookies.remove("email"); // Add. um repetido (Irá sobrescrever o
		 * 1º, pois Map<> não aceita repetições). cookies.put("phone",
		 * "(61)99711-1333");
		 * 
		 * // Verificar se contem alguma chave System.out.println("Contains 'phone' key
		 * :" + cookies.containsKey("phone"));
		 * 
		 * // Verificar o tamanho System.out.println("Map size: " + cookies.size());
		 * 
		 * // Resgatar alguma chave System.out.println("Username: " +
		 * cookies.get("username"));
		 * 
		 * // Resgatar alguma chave que não existe System.out.println("E-mail: " +
		 * cookies.get("email"));
		 * 
		 * // Print de cada chave/valor System.out.println("ALL COOKIES"); for (String
		 * key : cookies.keySet()) { System.out.println(key + ": " + cookies.get(key));
		 * 
		 * }
		 */

		// Exemplo 2:

		/**
		 * Map<Product, Double> stock = new HashMap<>();
		 * 
		 * Product p1 = new Product("Tv", 900.0); Product p2 = new
		 * Product("Notebook",1200.0); Product p3 = new Product("Tablet", 400.0);
		 * 
		 * stock.put(p1, 10000.0); stock.put(p2, 20000.0); stock.put(p3, 15000.0);
		 * 
		 * Product ps = new Product("Tv", 900.0);
		 * 
		 * System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
		 * 
		 */

		// Exercício de Fixação MAP

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votacao = new LinkedHashMap<>();
		
		
		// Lê o path do arquivo
		System.out.println("Enter file full path: ");
		String path = sc.next();

		// Lê cada linha do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			// Enquanto tiver algo escrito na linha
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer qtdeVotacao = Integer.parseInt(fields[1]);

				// Se houver o nome dentro do MAP, pega o nome atual e sobrescreve com a soma da votação.
				if (votacao.containsKey(name)) {
					int vote = votacao.get(name);
					votacao.put(name, vote + qtdeVotacao);
				} else {
					votacao.put(name, qtdeVotacao);
				}
				line = br.readLine();
			}

			// Lê o total
			for (String key : votacao.keySet()) {
				System.out.println(key + ": " + votacao.get(key));
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
}