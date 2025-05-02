package entities;

public class Product {
	private String name;
	private Double price;

	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100;
	}

	/**
	 * public static void staticPriceUpdateConsumer(Product p) {
	 * p.setPrice(p.getPrice() * 1.1); }
	 * 
	 * public void nonStaticPriceUpdateConsumer() { setPrice(getPrice() * 1.1); }
	 * 
	 * public static String staticUpperCaseName(Product p) { return
	 * p.getName().toUpperCase(); }
	 * 
	 * public String nonStaticUpperCaseName() { return getName().toUpperCase(); }
	 */
	
	@Override
	public String toString() {
		return name + ", " + price;
	}

}
