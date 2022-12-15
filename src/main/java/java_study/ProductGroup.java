package java_study;

import java.io.Serializable;

public class ProductGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public ProductGroup() {
		
	}
	
	public ProductGroup(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductGroup [id=" + id + ", name=" + name + "]";
	}

}
