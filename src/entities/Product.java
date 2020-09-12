package entities;

public class Product {
	
	private String name;
	private double price;
	private int quantities;
	
	public Product(String name, double price, int quantities) {
		this.name = name;
		this.price = price;
		this.quantities = quantities;
	}

	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public int getQuantities() {
		return quantities;
	}


	public double value(double price, int quantities) {
		return price * quantities;
	}
	
	@Override
	public String toString() {
		return name + ", $" + String.format("%.2f", (value(price, quantities)));
	}
	
	
}
