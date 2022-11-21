package java_study;

public class Product {
	
	private String name;
	private Double price;
	private Integer stock = 0;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Product(String name, Double price, Integer stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public boolean isAvailable() {
		return stock > 0; 
	}

}
