package java_study;

import java.util.Arrays;
import java.util.List;

public class GenericStudy1 {

	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50);
		List<String> stringList = Arrays.asList("Ana", "Jhon", "Joe", "Mary");
		List<?> superList1 = integerList;
		List<?> superList2 = stringList;

		printList(integerList);
		printList(stringList);
		printList(superList1);
		printList(superList2);
	}
	
	private static void printList(List<?> list) {
		MiscStudy.printMethodName();
		for (Object item : list)
			System.out.println(item);
		System.out.println();
	}
	
}
