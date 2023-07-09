package java_study;

import java.util.Arrays;
import java.util.Random;

public class ArrayStudy {

	public static void main(String[] args) {
		arraySort();
		parallelArraySort();
	}

	private static void arraySort() {
		MiscStudy.printMethodName();
		final int[] values = new int[10];
		final Random rand = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = rand.nextInt(20);
		}
		System.out.println("Initial.....: " + Arrays.toString(values));
		Arrays.sort(values, 0, 5);
		System.out.println("Partial sort: " + Arrays.toString(values));
		Arrays.sort(values);
		System.out.println("Total sort..: " + Arrays.toString(values));
		System.out.println();
	}
	
	private static void parallelArraySort() {
		MiscStudy.printMethodName();
		
		final int size = 10000000;
		final int[] values1 = new int[size];
		final int[] values2 = new int[size];

		System.out.println("Generating random values...");
		final Random rand = new Random();
		for (int i = 0; i < values1.length; i++) {
			int value = rand.nextInt(255);
			values1[i] = value;
			values2[i] = value;
		}
		
		System.out.println("Sorting array...");
		long t1 = System.currentTimeMillis();
		Arrays.sort(values1);
		t1 = System.currentTimeMillis() - t1;
		
		System.out.println("Parallel sorting array...");
		long t2 = System.currentTimeMillis();
		Arrays.parallelSort(values1);
		t2 = System.currentTimeMillis() - t2;

		System.out.println("Elapsed time:");
		System.out.println("\tSort.........: " + t1 + " ms");
		System.out.println("\tParallel sort: " + t2 + " ms");
		System.out.println();
		
	}
	

}
