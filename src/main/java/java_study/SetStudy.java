package java_study;

import java.util.HashSet;
import java.util.Set;

public class SetStudy {

	public static void main(String[] args) {
		stringHashSet();
	}
	
	private static void stringHashSet() {
		MiscStudy.printMethodName();
		
		Set<String> set = new HashSet<>();
		set.add("Emily");
		set.add("Jhon");
		set.add("Sophia");
		set.add("Bob");
		
		// HashSet is not sorted!
		for (String s : set)
			System.out.println(s);
		
		System.out.println();
		System.out.println("contains B: " + set.contains("Jhon"));
		System.out.println("contains D: " + set.contains("Jacob"));
		System.out.println();
	}

}
