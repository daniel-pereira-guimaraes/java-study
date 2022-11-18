package java_study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetStudy {

	public static void main(String[] args) {
		operationsWithSet();
		stringHashSet();
		stringLinkedHashSet();
		stringTreeSet();
	}
	
	private static void operationsWithSet() {
		MiscStudy.printMethodName();
		
		Set<Integer> set = Set.of(5, 9, 10, 3);
		
		System.out.print("Elements: ");
		boolean first = true;
		for (Integer i : set) { 
			System.out.print((first ? "" : ", ") + i);
			first = false;
		}
		System.out.println();
		
		System.out.println("Checking if it contains individual elements...");
		for (int i = 1; i <= 10; i++)
			System.out.println("\tset.contains(" + i + "): " + set.contains(i));
		
		System.out.println("Checking if it contains collections of elements...");
		List<Integer> list = Arrays.asList(3, 5, 10);
		Set<Integer> primes = Set.of(2, 3, 5);
		System.out.println("\tset.containsAll(" + list + "): " + set.containsAll(list));
		System.out.println("\tset.containsAll(" + primes + "): " + set.containsAll(primes));
		System.out.println();
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

	
	private static void stringTreeSet() {
		MiscStudy.printMethodName();
		
		Set<String> set = new TreeSet<>(); // Ordered by compareTo!
		set.add("Emily");
		set.add("Jhon");
		set.add("Sophia");
		set.add("Bob");
		
		for (String s : set)
			System.out.println(s);
		
		System.out.println();
	}
	
}
