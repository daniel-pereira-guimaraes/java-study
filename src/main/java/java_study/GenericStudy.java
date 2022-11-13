package java_study;

import java.util.ArrayList;
import java.util.List;

public class GenericStudy {
	
	private static class ListService<T> {
		
		List<T> list = new ArrayList<T>();
		
		private void checkEmpty() {
			if (list.size() == 0)
				throw new RuntimeException("List is empty.");
		}
		
		public void add(T value) {
			list.add(value);
		}
		
		public T getFirst() {
			checkEmpty();
			return list.get(0);
		}
		
		public T getLast() {
			checkEmpty();
			return list.get(list.size() - 1);
		}
		
		public void print(String caption) {
			checkEmpty();
			if (caption != null && !caption.isBlank())
				System.out.print(caption + ": ");
			System.out.print("[");
			for (int i = 0; i < list.size(); i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(list.get(i));
			}
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		testListServiceWithString();
		testListServiceWithInteger();
	}
	
	private static void testListServiceWithString() {
		MiscStudy.printMethodName();
		ListService<String> listService = new ListService<String>();
		listService.add("One");
		listService.add("Two");
		listService.add("Three");
		listService.print("List");
		System.out.println("First: " + listService.getFirst());
		System.out.println("Last: " + listService.getLast());
		System.out.println();
	}

	private static void testListServiceWithInteger() {
		MiscStudy.printMethodName();
		ListService<Integer> listService = new ListService<Integer>();
		for (int i = 1; i <= 10; i++)
			listService.add(i);
		listService.print("List");
		System.out.println("First: " + listService.getFirst());
		System.out.println("Last: " + listService.getLast());
		System.out.println();
	}
	
}
