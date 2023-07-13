package java_study;

import java.io.IOException;

import org.apache.commons.lang3.SerializationUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class CloneStudy {
	
	public static void main(String[] args) {
		try {
			cloneWidhSerialization();
			cloneWidhGson();
			cloneWidhJackson();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
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
	
	private static void cloneWidhJackson() throws IOException {
		MiscStudy.printMethodName();
		
		Product p1 = new Product(100L, "Keyboard", 15.0, 10, new ProductGroup(1L, "Eletronics"));

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Product p2 = mapper.readValue(mapper.writeValueAsBytes(p1), Product.class);
		Product p3 = mapper.readValue(mapper.writeValueAsBytes(p1), Product.class);

		p3.setId(200L);
		p3.setName("Kite");
		p3.getGroup().setName("Toys");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println();
	}
	
}
