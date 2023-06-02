package java_study;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectionStudy {
	
	public static void main(String[] args) {
		callPrivateMethod();
	}
	
	private static void callPrivateMethod() {
		final List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
		final Product product = new Product();
		try {
			final Method method = Product.class.getDeclaredMethod("privateMethodForTest", List.class);
			method.setAccessible(true);
			final int total = (int) method.invoke(product, lista);
			System.out.println("Total: " + total);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
