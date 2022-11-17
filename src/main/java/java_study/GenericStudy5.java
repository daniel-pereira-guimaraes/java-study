package java_study;

import java.util.Arrays;
import java.util.List;

public class GenericStudy5 {

	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(1, 5, 8);
		List<Double> doubleList = Arrays.asList(1.5, 2.3, 4.0);
		List<Number> numberList1 = Arrays.asList(1, 2.5, 3);
		List<? extends Number> numberList2 = Arrays.asList(1, 2, 5);
		List<? super Number> numberList3 = Arrays.asList(2, 54, 6.0);
		
		// Cannot assign List<Integer) to List<Number>!
		//numberList1 = integerList; 
		
		// Cannot assign List<Double> to List<Number>!
		//numberList1 = doubleList; 
		
		// Cannot assign List<? extends Number> to List<Number>!
		//numberList1 = numberList2; 
		
		// Cannot assign List<? super Number> to List<Number>!
		// numberList1 = numberList3;
		
		numberList2 = numberList1;
		numberList3 = numberList1;
		
		// Cannot assign List<? extends Number> to List<? super Number>
		//numberList3 = numberList2;
		
		//numberList1.add(10); Throw exception!
		Number x = numberList1.get(0);
		
		Number y = numberList2.get(0); // Can get!
		//numberList2.add(y); // Cannot put!
		
		//numberList3.add(30); // Throw exception!
		//Number z = numberList3.get(0); // Cannot get!
		
		System.out.print("integerList: ");
		for (int i = 0; i < integerList.size(); i++)
			System.out.print((i > 0 ? ", " : "") + integerList.get(i));
		System.out.println();

		System.out.print("doubleList: ");
		for (int i = 0; i < doubleList.size(); i++)
			System.out.print((i > 0 ? ", " : "") + doubleList.get(i));
		System.out.println();

		System.out.print("numberList3: ");
		for (int i = 0; i < numberList3.size(); i++)
			System.out.print((i > 0 ? ", " : "") + numberList3.get(i));
		System.out.println();
		
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

}
