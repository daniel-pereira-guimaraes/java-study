package java_study;

import java.text.ParseException;
import java.time.LocalDate;

import org.mockito.Mockito;

public class MockitoStudy {
	
	public static void main(String[] args) throws ParseException {
		mockCalculator();
		mockDateTime();
		spyDateTime();
	}
	
	private static void useCalculator(Calculator calculator) {
		MiscStudy.printMethodName();
		System.out.println("Sum: " + calculator.sum(2, 3));
		System.out.println("Mult: " + calculator.mult(3, 4));
	}
	
	private static void mockCalculator() {
		MiscStudy.printMethodName();
		final long start = System.currentTimeMillis();
		System.out.println("Mocking Calculator...");
		Calculator calculator = Mockito.mock(Calculator.class);
		System.out.println("Calculator mocked in " + (System.currentTimeMillis() - start) + " ms");
		Mockito.when(calculator.sum(2, 3)).thenReturn(10);
		useCalculator(calculator);
		System.out.println();
	}
	
	private static void mockDateTime() {
		MiscStudy.printMethodName();
		
		final DateTimeService concreteDateTimeService = new DateTimeService();
		
		final long start = System.currentTimeMillis();
		System.out.println("Mocking DateTimeService...");
		final DateTimeService mockedDateTimeService = Mockito.mock(DateTimeService.class);
		Mockito.when(mockedDateTimeService.localDate()).thenReturn(LocalDate.of(2023, 6, 1));
		System.out.println("DateTimeService mocked in " + (System.currentTimeMillis() - start) + " ms");

		System.out.println("CONCRETE INSTANCE");
		System.out.println("\tLocal date: " + concreteDateTimeService.localDate());
		System.out.println("\tLocal time: " + concreteDateTimeService.localTime());

		System.out.println("MOCKED INSTANCE");
		System.out.println("\tLocal date: " + mockedDateTimeService.localDate());
		System.out.println("\tLocal time: " + mockedDateTimeService.localTime());
		
		System.out.println();
	}
	
	private static void spyDateTime() {
		MiscStudy.printMethodName();
		final DateTimeService concreteDateTimeService = new DateTimeService();
		
		final long start = System.currentTimeMillis();
		System.out.println("Creating Spy DateTimeService...");
		final DateTimeService spyDateTimeService = Mockito.spy(DateTimeService.class);
		Mockito.when(spyDateTimeService.localDate()).thenReturn(LocalDate.of(2023, 6, 1));
		System.out.println("Spy DateTimeService created in " + (System.currentTimeMillis() - start) + " ms");

		System.out.println("CONCRETE INSTANCE");
		System.out.println("\tLocal date: " + concreteDateTimeService.localDate());
		System.out.println("\tLocal time: " + concreteDateTimeService.localTime());

		System.out.println("SPY INSTANCE");
		System.out.println("\tLocal date: " + spyDateTimeService.localDate());
		System.out.println("\tLocal time: " + spyDateTimeService.localTime());
		
		System.out.println();
	}

}
