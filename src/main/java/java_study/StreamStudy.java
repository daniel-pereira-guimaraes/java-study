package java_study;

import java.util.Arrays;
import java.util.List;

public class StreamStudy {

	public static void main(String[] args) {
		filterIntegerList();
		upperStringList();
		stringLengths();
		sumIntegerList1();
		sumIntegerList2();
		distinctValues();
	}
	
	private static void filterIntegerList() {
		MiscStudy.printMethodName();
		
		List<Integer> all = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> odd = all.stream().filter(i -> i % 2 == 1).toList();
		
		System.out.println("all: " + all);
		System.out.println("odd: " + odd);
		System.out.println();
	}

	private static void upperStringList() {
		MiscStudy.printMethodName();
		
		List<String> normal = Arrays.asList("Brazil", "Italy", "United States", "France");
		List<String> upper = normal.stream().map(s -> s.toUpperCase()).toList();
		
		System.out.println("normal: " + normal);
		System.out.println("upper: " + upper);
		System.out.println();
	}
	
	private static void stringLengths() {
		MiscStudy.printMethodName();
		
		List<String> strings = Arrays.asList("Brazil", "Italy", "United States", "France");
		int[] lengths = strings.stream().mapToInt(s -> s.length()).toArray();
		
		System.out.println("strings: " + strings);
		System.out.println("lengths: " + Arrays.toString(lengths));
		System.out.println();
	}
	
	private static void sumIntegerList1() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int sum = list.stream().reduce(0, (t, i) -> t + i).intValue();
		
		System.out.println("list: " + list);
		System.out.println("sum: " + sum);
		System.out.println();
	}

	private static void sumIntegerList2() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = list.stream().reduce(Integer::sum).get();
		
		System.out.println("list: " + list);
		System.out.println("sum: " + sum);
		System.out.println();
	}
	
	private static void distinctValues() {
		MiscStudy.printMethodName();
		List<Integer> all = Arrays.asList(2, 2, 6, 7, 8, 7, 5, 6, 2);
		List<Integer> distincts = all.stream().distinct().toList();
		System.out.println("All values: " + all);
		System.out.println("Distinct values: " + distincts);
		System.out.println();
	}
	
}
