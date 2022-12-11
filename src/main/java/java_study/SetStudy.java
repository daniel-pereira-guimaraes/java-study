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
		speedTest();
		unionSet();
		intersectionSet();
		diffSet();
	}
	
	private static void operationsWithSet() {
		MiscStudy.printMethodName();
		
		//Set<Integer> set = Set.of(5, 9, 10, 3); // Set.of not in Java 8?
		Set<Integer> set = new HashSet<>(Arrays.asList(5, 9, 10, 3));
		
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
		//Set<Integer> primes = Set.of(2, 3, 5); // Set.of not in Java 8?
		Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5));
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
	
	@SuppressWarnings("unused")
	private static int countForSpeedTest(Set<?> set) {
		int count = 0;
		for (Object o : set) 
			count++;
		return count;
	}
	
	private static void speedTest(Set<?> set) {
		@SuppressWarnings("unused")
		int count = 0;
		final long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20; i++)
			count = countForSpeedTest(set);
		final long endTime = System.currentTimeMillis();
		final long time = endTime - startTime;
		System.out.println("\t" + set.getClass().getSimpleName() + ": " + time + " ms");
	}
	
	private static void speedTest() {
		MiscStudy.printMethodName();
		
		final Set<Integer> hashSet = new HashSet<>();
		final Set<Integer> linkedHashSet = new LinkedHashSet<>();
		final Set<Integer> treeSet = new TreeSet<>();
		final int count = 1000000;

		System.out.println("ADD TIME:");

		long time = System.currentTimeMillis();
		for (Integer i = count; i > 0; i--)
			hashSet.add(i);
		time = System.currentTimeMillis() - time;
		System.out.println("\tHashSet: " + time + " ms");
		
		time = System.currentTimeMillis();
		for (Integer i = count; i > 0; i--)
			linkedHashSet.add(i);
		time = System.currentTimeMillis() - time;
		System.out.println("\tLinkedHashSet: " + time + " ms");

		time = System.currentTimeMillis();
		for (Integer i = count; i > 0; i--)
			treeSet.add(i);
		time = System.currentTimeMillis() - time;
		System.out.println("\tTreeSet: " + time + " ms");
		
		System.out.println("READ TIME:");
		speedTest(hashSet);
		speedTest(linkedHashSet);
		speedTest(treeSet);
		
		System.out.println();
	}
	
	private static void unionSet() {
		MiscStudy.printMethodName();
		final Set<Integer> a = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 0));
		final Set<Integer> b = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8));
		final Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a UNION b = " + c);
		System.out.println();
	}

	private static void intersectionSet() {
		MiscStudy.printMethodName();
		final Set<Integer> a = new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 0));
		final Set<Integer> b = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8));
		final Set<Integer> c = new TreeSet<>(a);
		c.retainAll(b);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a INTERSECTION b = " + c);
		System.out.println();
	}

	private static void diffSet() {
		MiscStudy.printMethodName();
		final Set<Integer> a = new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 0));
		final Set<Integer> b = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8));
		final Set<Integer> c = new TreeSet<>(a);
		c.removeAll(b);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a - b = " + c);
		System.out.println();
	}
	
}
