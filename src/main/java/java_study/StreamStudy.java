package java_study;

import java.util.Arrays;
import java.util.List;

public class StreamStudy {

	public static void main(String[] args) {
		filterIntegerList();
	}
	
	private static void filterIntegerList() {
		MiscStudy.printMethodName();
		
		List<Integer> all = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> odd = all.stream().filter(i -> i % 2 == 1).toList();
		
		System.out.println("all: " + all);
		System.out.println("odd: " + odd);
		System.out.println();
	}

}
