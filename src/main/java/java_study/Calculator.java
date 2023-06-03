package java_study;

public class Calculator {
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public int sum(int[] numbers) {
		int sum = 0;
		for (int n : numbers) 
			sum += n;
		return sum;
	}
	
	public int mult(int a, int b) {
		return a * b;
	}

}
