package java_study;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;

public class CloneStudy {
	
	public static void main(String[] args) {
		cloneWidhSerialization();
		cloneWidhGson();
	}
	
	private static void cloneWidhSerialization() {
		MiscStudy.printMethodName();
		
		Product p1 = new Product(100L, "Keyboard", 15.0, 10, new ProductGroup(1L, "Eletronics"));
		Product p2 = SerializationUtils.clone(p1);
		Product p3 = SerializationUtils.clone(p1);
		
		p3.setId(200L);
		p3.setName("Kite");
		p3.getGroup().setName("Toys");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println();
	}

	private static void cloneWidhGson() {
		MiscStudy.printMethodName();
		
		Product p1 = new Product(100L, "Keyboard", 15.0, 10, new ProductGroup(1L, "Eletronics"));

		Gson gson = new Gson();
		Product p2 = gson.fromJson(gson.toJson(p1), Product.class);
		Product p3 = gson.fromJson(gson.toJson(p1), Product.class);

		p3.setId(200L);
		p3.setName("Kite");
		p3.getGroup().setName("Toys");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println();
	}
	
}
