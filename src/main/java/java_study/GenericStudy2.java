package java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericStudy2 {
	
	private static class Car implements Comparable<Car> {
		private String model;
		private int velocity;
		
		public Car(String model, int velocity) {
			this.model = model;
			this.velocity = velocity;
		}
		
		public int getVelocity() {
			return velocity;
		}
		
		@Override
		public String toString() {
			return "{model: " + model + ", velocity: " + velocity + "}";
		}

		@Override
		public int compareTo(Car other) {
			return Integer.compare(velocity, other.getVelocity());
		}
	}
	
	private static class Product implements Comparable<Product>{
		private String name;
		private Double price;
		
		public Product(String name, Double price) {
			this.name = name;
			this.price = price;
		}
		
		public Double getPrice() {
			return price;
		}
		
		@Override
		public String toString() {
			return "{name: " + name + ", price: " + price + "}";
		}

		@Override
		public int compareTo(Product other) {
			return price.compareTo(other.getPrice());
		}
	}
	
	private static class CalculatorService {
		
		public static <T extends Comparable<T>> T max(List<T> list) {
			T maxItem = list.get(0);
			for (T item : list) {
				if (item.compareTo(maxItem) > 0)
					maxItem = item;
			}
			return maxItem;
		}
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(3,9,15,0,4,-9));

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("SSD", 50.0));
		products.add(new Product("Keyboad", 20.0));
		products.add(new Product("Mouse", 10.0));
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("SSC Ultimate Aero", 412));
		cars.add(new Car("Koenigsegg Agera RS", 447));
		cars.add(new Car("Bugatti Veyron EB 16.4", 408));
		
		Integer maxInteger = CalculatorService.max(integers);
		Product maxProduct = CalculatorService.max(products);
		Car maxCar = CalculatorService.max(cars);
		
		System.out.println("Max integer: " + maxInteger);
		System.out.println("Max product: " + maxProduct);
		System.out.println("Max car: " + maxCar);
	}

}
