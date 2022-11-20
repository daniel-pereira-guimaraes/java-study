package java_study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	}
	
	private static void sortByLength() {
		MiscStudy.printMethodName();
		List<String> names =  Arrays.asList("Joe", "Gilbert", "Amelia", "Jhon", "Bob");
		names.sort((a,b) -> Integer.valueOf(a.length()).compareTo(b.length())); 
		names.forEach(s -> System.out.println(s.toUpperCase()));
		System.out.println();
	}
	
	private static void sortByDistinctLetterCount() {
		MiscStudy.printMethodName();
		List<String> names =  Arrays.asList("Joe", "Gilbert", "Amelia", "Lee", "Anna");
		names.sort(LambdaStudy::compareLetterCount); 
		names.forEach(System.out::println);
		System.out.println();
	}

}