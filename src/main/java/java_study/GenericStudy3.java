package java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericStudy3 {
	
	private static class Car implements Comparable<Car> {
		private String model;
		private int velocity;
		
		public Car(String model, int velocity) {
			this.model = model;
			this.velocity = velocity;
		}
		
		public String getModel() {
			return model;
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
	
	private static class RaceCar extends Car {
		
		private String category;
		
		public RaceCar(String model, String category, int velocity) {
			super(model, velocity);
			this.category = category;
		}
		
		@Override
		public String toString() {
			return "{model: " + getModel() + ", category: " + category + ", velocity: " + getVelocity() + "}";
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
		
		public static <T extends Comparable<? super T>> T max(List<T> list) {
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
		
		List<String> names = new ArrayList<String>(Arrays.asList("Tom", "Timon", "Sid", "Jerry"));

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("SSD", 50.0));
		products.add(new Product("Keyboad", 20.0));
		products.add(new Product("Mouse", 10.0));
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("SSC Ultimate Aero", 412));
		cars.add(new Car("Koenigsegg Agera RS", 447));
		cars.add(new Car("Bugatti Veyron EB 16.4", 408));
		
		List<RaceCar> raceCars = new ArrayList<RaceCar>();
		raceCars.add(new RaceCar("Ferrari", "F1", 400));
		raceCars.add(new RaceCar("Mercedes", "F1", 390));
		
		Integer maxInteger = CalculatorService.max(integers);
		String maxName = CalculatorService.max(names);
		Product maxProduct = CalculatorService.max(products);
		Car maxCar = CalculatorService.max(cars);
		RaceCar maxRaceCar = CalculatorService.max(raceCars);
		
		System.out.println("Max integer: " + maxInteger);
		System.out.println("Max name: " + maxName);
		System.out.println("Max product: " + maxProduct);
		System.out.println("Max car: " + maxCar);
		System.out.println("Max race car: " + maxRaceCar);
	}

}
