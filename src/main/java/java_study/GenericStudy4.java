package java_study;

import java.util.Arrays;
import java.util.List;

public class GenericStudy4 {
	
	private static interface Shape {
		double getArea();
	}
	
	private static class Rectangle implements Shape {
		
		private double width;
		private double height;
		
		public Rectangle(double width, double height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public double getArea() {
			return width * height;
		}
		
	}
	
	private static class Circle implements Shape {
		
		private double radius;
		
		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public double getArea() {
			return Math.PI * (radius * radius);
		}
		
	}
	
	private static void printArea1(List<Shape> list) {
		MiscStudy.printMethodName();
		//list.add(new Rectangle(4));
		double total = 0;
		for (Shape shape : list) {
			System.out.println(shape.getClass().getSimpleName() + ": " + shape.getArea());
			total += shape.getArea();
		}
		System.out.println("Total area: " + total);
		System.out.println();
	}

	public static void main(String[] args) {
		List<Shape> rectangles = Arrays.asList(
			new Circle(2), 
			new Rectangle(2, 5),
			new Circle(3));
		printArea1(rectangles);
	}

}
