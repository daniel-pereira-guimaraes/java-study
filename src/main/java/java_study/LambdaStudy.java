package java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class LambdaStudy {
	
	private static int compareLetterCount(String a, String b) {
		Set<String> aLetters = new HashSet<>(Arrays.asList(a.toUpperCase().split("")));
		Set<String> bLetters = new HashSet<>(Arrays.asList(b.toUpperCase().split("")));
		Integer aSize = aLetters.size();
		Integer bSize = bLetters.size();
		return  aSize.compareTo(bSize);
	}

	public static void main(String[] args) {
		sortByLength();
		sortByDistinctLetterCount();
		processList();
		clearList();
	}
	
	private static void sortByLength() {
		MiscStudy.printMethodName();
		List<String> names = Arrays.asList("Joe", "Gilbert", "Amelia", "Jhon", "Bob");
		names.sort((a,b) -> Integer.valueOf(a.length()).compareTo(b.length())); 
		names.forEach(s -> System.out.println(s.toUpperCase()));
		System.out.println();
	}
	
	private static void sortByDistinctLetterCount() {
		MiscStudy.printMethodName();
		List<String> names = Arrays.asList("Joe", "Gilbert", "Amelia", "Lee", "Anna");
		names.sort(LambdaStudy::compareLetterCount); 
		names.forEach(System.out::println);
		System.out.println();
	}
	
	private static void processList() {
		MiscStudy.printMethodName();
		List<String> names = Arrays.asList("Joe", "Gilbert", "Amelia", "Lee", "Anna");

		Consumer<String> print = s -> System.out.println(s);
		Consumer<String> upperPrint = s-> System.out.println(s.toUpperCase());

		names.forEach(print);
		System.out.println();
		names.forEach(upperPrint);
		System.out.println();
	}
	
	private static void clearList() {
		MiscStudy.printMethodName();
		List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1,2,3,4,5,6,7,8,9));
		numbers.removeIf(n -> n % 2 == 0);
		numbers.forEach(System.out::println);
	}

}
