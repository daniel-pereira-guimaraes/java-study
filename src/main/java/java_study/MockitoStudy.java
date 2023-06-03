package java_study;

import org.mockito.Mockito;

public class MockitoStudy {
	
	public static void main(String[] args) {
		mockCalculator();
	}
	
	private static void useCalculator(Calculator calculator) {
		MiscStudy.printMethodName();
		System.out.println("Sum: " + calculator.sum(2, 3));
		System.out.println("Mult: " + calculator.mult(3, 4));
		System.out.println();
	}
	
	private static void mockCalculator() {
		MiscStudy.printMethodName();
		final long start = System.currentTimeMillis();
		System.out.println("Mocking Calculator...");
		Calculator calculator = Mockito.mock(Calculator.class);
		System.out.println("Calculator mocked in " + (System.currentTimeMillis() - start) + " ms");
		Mockito.when(calculator.sum(2, 3)).thenReturn(10);
		useCalculator(calculator);
		System.out.println(MiscStudy.getMethodName() + " - Done!");
	}
	
	

}
