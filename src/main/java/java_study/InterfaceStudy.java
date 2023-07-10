package java_study;

import java.util.Arrays;
import java.util.List;

public class InterfaceStudy {

	public static interface Printer {
		
		public void print(String value);
		
		default void print(String[] values) {
			for (String value : values) {
				print(value);
			}
		}
		
		default void print() {
			print("");
		}
		
	}
	
	public static class ConsolePrinter implements Printer {

		@Override
		public void print(String value) {
			System.out.println(value);
		}
		
	}

	public static interface OneInterface {
		
		default void oneMethod() {
			System.out.println(getClass().getSimpleName() + ".oneMethod()");
		}
		
	}
	
	public static interface TwoInterface {

		default void twoMethod() {
			System.out.println(getClass().getSimpleName() + ".twoMethod()");
		}
		
	}
	
	public static class OneAndTwo implements OneInterface, TwoInterface {
	}
	

	public static void main(String[] args) {

		useConsolePrinter();
		usePrinterWithLambda((s) -> System.out.println(s));
		useOneAndTwo();
		
	}
	
	private static void useConsolePrinter() {
		MiscStudy.printMethodName();
		final ConsolePrinter printer = new ConsolePrinter();
		printer.print("Hello!");
		printer.print(new String[] {"One", "Two", "Three"});
		printer.print();
	}
	
	private static void usePrinterWithLambda(Printer printer) {
		MiscStudy.printMethodName();
		final List<String> list = Arrays.asList("One", "Two", "Three");
		list.forEach(s -> printer.print(s));
		printer.print(new String[] {"A", "B", "C"});
		printer.print();
	}
	
	private static void useOneAndTwo() {
		MiscStudy.printMethodName();
		OneAndTwo oneAndTwo = new OneAndTwo();
		oneAndTwo.oneMethod();
		oneAndTwo.twoMethod();
		System.out.println();
	}
	
}
