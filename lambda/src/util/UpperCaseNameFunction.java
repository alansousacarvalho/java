package util;

import java.util.function.Function;

import entities.Product;

public class UpperCaseNameFunction implements Function<Product, String> {

	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}

}
