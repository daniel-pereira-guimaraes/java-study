package java_study;

import java.util.Arrays;
import java.util.List;

public class GenericStudy1 {

	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50);
		List<Double> doubleList = Arrays.asList(2.0, 3.5, 5.2, 10.3);
		List<String> stringList = Arrays.asList("Ana", "Jhon", "Joe", "Mary");
		List<?> superList1 = integerList;
		List<?> superList2 = stringList;
		List<? extends Number> superList3 = doubleList;

		printList(integerList);
		printList(stringList);
		printList(superList1);
		printList(superList2);
		
		printNumberList(integerList);
		printNumberList(doubleList);
		printNumberList(superList3);
	}
	
	private static void printList(List<?> list) {
		MiscStudy.printMethodName();
		for (Object item : list)
			System.out.println(item);
		System.out.println();
	}
	
	private static void printNumberList(List<? extends Number> list) {
		MiscStudy.printMethodName();
		for (Number n : list)
			System.out.println("2 x " + n + " = " + 2 * n.doubleValue());
		System.out.println();
	}
	
}
