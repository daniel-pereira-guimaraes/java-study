package java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamStudy {

	public static void main(String[] args) {
		filterIntegerList();
		upperStringList();
		stringLengths();
		sumIntegerList1();
		sumIntegerList2();
		distinctValues();
		checkIfAllAreOdd();
		convertList();
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
	
	private static void checkIfAllAreOdd() {
		MiscStudy.printMethodName();
		List<Integer> list1 = Arrays.asList(2, 4, 16, 14, 8, 2, 19, 10, 12);
		List<Integer> list2 = Arrays.asList(3, 1, 15, 17, 9, 7, 11, 21, 23);
		List<Integer> list3 = Arrays.asList(3, 1, 15, 17, 8, 7, 11, 21, 23);
		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		for (List<Integer> list : listOfLists) {
			if (list.stream().allMatch(i -> i % 2 == 1))
				System.out.println(list + ": All are odd!");
			else
				System.out.println(list + ": Not all are odd!");
		}
		System.out.println();
	}
	
	private static void convertList() {
		MiscStudy.printMethodName();
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "Mouse", 15.0, 50));
		products.add(new Product(2L, "Keyboard", 25.0, 30));
		products.add(new Product(3L, "TV", 240.0, 20));
		products.add(new Product(4L, "Tablet", 120.0, 15));
		
		List<ProductDTO> dtos = products.stream().map(
			p -> new ProductDTO(p.getName(), p.getPrice())).toList();
		
		System.out.println("PRODUCTS:");
		products.forEach(p -> System.out.println("\t" + p));
		
		System.out.println("DTOs:");
		dtos.forEach(dto -> System.out.println("\t" + dto));
		
		System.out.println();
	}
	
}
