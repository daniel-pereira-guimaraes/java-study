package java_study;

import java.util.Arrays;
import java.util.List;

public class LambdaStudy {

	public static void main(String[] args) {
		sortByLength();
	}
	
	private static void sortByLength() {
		MiscStudy.printMethodName();
		List<String> names =  Arrays.asList("Joe", "Gilbert", "Amelia", "Jhon", "Bob");
		names.sort((a,b) -> Integer.valueOf(a.length()).compareTo(b.length())); 
		names.forEach(s -> System.out.println(s.toUpperCase()));
		System.out.println();
	}

}
