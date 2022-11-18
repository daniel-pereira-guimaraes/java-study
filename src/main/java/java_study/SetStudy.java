package java_study;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetStudy {

	public static void main(String[] args) {
		stringHashSet();
		stringLinkedHashSet();
	}
	
	private static void stringHashSet() {
		MiscStudy.printMethodName();
		
		Set<String> set = new HashSet<>(); // HashSet is not sorted!
		set.add("Emily");
		set.add("Jhon");
		set.add("Sophia");
		set.add("Bob");
		
		for (String s : set)
			System.out.println(s);
		
		System.out.println();
		System.out.println("contains B: " + set.contains("Jhon"));
		System.out.println("contains D: " + set.contains("Jacob"));
		System.out.println();
	}

	private static void stringLinkedHashSet() {
		MiscStudy.printMethodName();
		
		Set<String> set = new LinkedHashSet<>(); // Addition order.
		set.add("Emily");
		set.add("Jhon");
		set.add("Sophia");
		set.add("Bob");
		
		for (String s : set)
			System.out.println(s);
		
		System.out.println();
	}
	
}
