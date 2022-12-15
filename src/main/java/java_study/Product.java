package java_study;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private Integer stock = 0;
	private ProductGroup group;

	public Product() {
		
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Product(String name, Double price, Integer stock) {
		this(name, price);
		this.stock = stock;
	}

	public Product(Long id, String name, Double price, Integer stock) {
		this(name, price, stock);
		this.id = id;
	}

	public Product(Long id, String name, Double price, Integer stock, ProductGroup group) {
		this(id, name, price, stock);
		this.group = group;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public ProductGroup getGroup() {
		return group;
	}

	public void setGroup(ProductGroup group) {
		this.group = group;
	}

	public boolean isAvailable() {
		return stock > 0; 
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", group=" + group
				+ "]";
	}

}
