package java_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		sortAsc();
		sortDesc1();
		sortDesc2();
		doubleSort1();
		doubleSort2();
		sortByTwoFields();
		ranking();
		iterateAndLimite();
		fibonacci((byte)10);
		multiplyIntegers();
		filterMapCollect();
		arithmeticAverage();
	}

	private static void filterIntegerList() {
		MiscStudy.printMethodName();
		
		List<Integer> all = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		// List<Integer> odd = all.stream().filter(i -> i % 2 == 1).toList(); // toList not in Java 8?
		List<Integer> odd = all.stream().filter(i -> i % 2 == 1).collect(Collectors.toList());
		
		System.out.println("all: " + all);
		System.out.println("odd: " + odd);
		System.out.println();
	}

	private static void upperStringList() {
		MiscStudy.printMethodName();
		
		List<String> normal = Arrays.asList("Brazil", "Italy", "United States", "France");
		List<String> upper = normal.stream().map(String::toUpperCase).collect(Collectors.toList());
		
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
		Integer sum = list.stream().reduce(Integer::sum).orElse(0);
		
		System.out.println("list: " + list);
		System.out.println("sum: " + sum);
		System.out.println();
	}
	
	private static void distinctValues() {
		MiscStudy.printMethodName();
		List<Integer> all = Arrays.asList(2, 2, 6, 7, 8, 7, 5, 6, 2);
		List<Integer> distincts = all.stream().distinct().collect(Collectors.toList());
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
			p -> new ProductDTO(p.getName(), p.getPrice())).collect(Collectors.toList());
		
		System.out.println("PRODUCTS:");
		products.forEach(p -> System.out.println("\t" + p));
		
		System.out.println("DTOs:");
		dtos.forEach(dto -> System.out.println("\t" + dto));
		
		System.out.println();
	}
	
	private static void sortAsc() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(3, 4, 1, 10, 5, 2);
		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println("List: " + list);
		System.out.println("Sorted: " + sorted);
		System.out.println();
	}

	private static void sortDesc1() {
		MiscStudy.printMethodName();
		
		Comparator<Integer> comp = Comparable::compareTo;
		
		List<Integer> list = Arrays.asList(3, 1, 5, 2, 8, 4, 10);
		List<Integer> sorted = list.stream().sorted(comp.reversed()).collect(Collectors.toList());
		
		System.out.println("List: " + list);
		System.out.println("Sorted: " + sorted);
		System.out.println();
	}

	private static void sortDesc2() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(1, 10, 2, 9, 3, 8, 4, 7, 5);
		List<Integer> sorted = list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());

		System.out.println("List: " + list);
		System.out.println("Sorted: " + sorted);
		System.out.println();
	}

	private static void doubleSort1() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(1,15,14,2,3,13,12,4,5,11,10,6,7,9,8);
		List<Integer> sorted = new ArrayList<>();
		sorted.addAll(list.stream().filter(i -> i % 2 == 1).sorted().collect(Collectors.toList()));
		sorted.addAll(list.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList()));
		
		System.out.println("List: " + list);
		System.out.println("Sorted: " + sorted);
		System.out.println();
	}
	
	private static void doubleSort2() {
		MiscStudy.printMethodName();
		
		final List<Integer> list = Arrays.asList(1,15,14,2,3,13,12,4,5,11,10,6,7,9,8);

		final Comparator<Integer> comparator = Comparator
				.comparing((Integer n) -> n % 2 == 0 ? 1 : -1)
				.thenComparing(n -> n);
		
		List<Integer> sorted = list.stream().sorted(comparator).collect(Collectors.toList());
		
		System.out.println("List: " + list);
		System.out.println("Sorted: " + sorted);
		System.out.println();
	}

	private static void sortByTwoFields() {
		MiscStudy.printMethodName();
		
		final List<Product> list = Arrays.asList(
				new Product(1L, "Pencil", 5.0, 30),
				new Product(2L, "Pen", 5.0, 10),
				new Product(3L, "Mouse", 10.0, 15),
				new Product(4L, "Keyboard", 10.0, 5),
				new Product(5L, "Monitor", 60.0, 3),
				new Product(6L, "Printer", 60.0, 0));
		
		final Function<Product, Double> byPrice = Product::getPrice;
		final Function<Product, Integer> byStock = Product::getStock;
		final Comparator<Product> comparator = Comparator.comparing(byPrice).reversed().thenComparing(byStock);
		
		final List<Product> sorted = list.stream().sorted(comparator).collect(Collectors.toList());

		System.out.println("LIST:");
		list.forEach(p -> System.out.println("\t" + p));
		
		System.out.println("SORTED:");
		sorted.forEach(p -> System.out.println("\t" + p));

		System.out.println();
	}
	
	private static void ranking() {
		MiscStudy.printMethodName();
		List<Integer> list = Arrays.asList(2, 4, 19, 16, 2, 14, 8, 19, 10, 12, 14);
		List<Integer> top5 = list.stream().distinct().sorted((a, b) -> b - a).limit(5).collect(Collectors.toList());
		System.out.println("List: " + list);
		System.out.println("Top5: " + top5);
		System.out.println();
	}
	
	private static void iterateAndLimite() {
		MiscStudy.printMethodName();
		
		Stream<Integer> stream = Stream.iterate(1, x -> 3 * x);
		System.out.println(Arrays.toString(stream.limit(5).toArray()));

		stream = Stream.iterate(1, x -> 3 * x);
		System.out.println(Arrays.toString(stream.limit(10).toArray()));
		
		System.out.println();
	}
	
	private static void fibonacci(byte n) {
		MiscStudy.printMethodName();
		
		Stream<Long> stream = Stream.iterate(new Long[] {0L, 1L}, a -> new Long[] {a[1], a[0] + a[1]}).map(b -> b[1]);
		System.out.println(Arrays.toString(stream.limit(n).toArray()));
		
		System.out.println();
	}
	
	private static void multiplyIntegers() {
		MiscStudy.printMethodName();
		
		List<Integer> list = Arrays.asList(2, 5, 3, 4);
		int result = list.stream().reduce(1,  (a, b) -> a * b);
		
		System.out.println("List: " + list);
		System.out.println("Result: " + result);
		System.out.println();
	}
	
	private static void filterMapCollect() {
		MiscStudy.printMethodName();
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> list2 = list1.stream()
			.filter(i -> i % 2 == 0)
			.map(i -> i * 10)
			.collect(Collectors.toList());
		
		System.out.println("List1: " + list1);
		System.out.println("List2: " + list2);
		System.out.println();
	}
	
	private static void arithmeticAverage() {
		MiscStudy.printMethodName();
		
		List<Double> values = Arrays.asList(10.0, 5.0, 2.5, 12.5);
		Double average = values.stream().reduce(0.0, (a, b) -> a + b) / values.size();
		
		System.out.println("Values: " + values);
		System.out.println("Average: " + average);
		System.out.println();
	}
	
}