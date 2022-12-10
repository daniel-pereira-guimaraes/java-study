package java_study;

public class EnumStudy {

	public static void main(String[] args) {
		
		basicEnumOperations();
		
		
	}
	
	private static enum SaleStatus {
		PENDING,
		PROCESSING,
		SHIPPED,
		DELIVERED
	}
	
	private static void basicEnumOperations() {
		MiscStudy.printMethodName();
		
		SaleStatus saleStatus1 = SaleStatus.PENDING;
		SaleStatus saleStatus2 = SaleStatus.PROCESSING;
		SaleStatus saleStatus3 = SaleStatus.SHIPPED;
		SaleStatus saleStatus4 = SaleStatus.valueOf("SHIPPED");

		System.out.println("saleStatus1: " + saleStatus1);
		System.out.println("saleStatus2: " + saleStatus2);
		System.out.println("saleStatus3: " + saleStatus3);
		System.out.println("saleStatus4: " + saleStatus4);
		
		System.out.println("saleStatus1.name: " + saleStatus1.name());
		System.out.println("saleStatus1.toString(): " + saleStatus1.toString());
		System.out.println("saleStatus1.ordinal: " + saleStatus1.ordinal());
		System.out.println("saleStatus2.ordinal: " + saleStatus2.ordinal());
		
		System.out.println("saleStatus1 compareTo saleStatus2: " + saleStatus1.compareTo(saleStatus2));
		System.out.println("saleStatus1 compareTo saleStatus3: " + saleStatus1.compareTo(saleStatus3));
		System.out.println("saleStatus1 compareTo saleStatus4: " + saleStatus1.compareTo(saleStatus4));
		
		System.out.println("saleStatus3 compareTo saleStatus4: " + saleStatus3.compareTo(saleStatus4));
		System.out.println("saleStatus3 compareTo saleStatus2: " + saleStatus3.compareTo(saleStatus2));
		System.out.println("saleStatus3 compareTo saleStatus1: " + saleStatus3.compareTo(saleStatus1));
		
		System.out.println();
	}
	
}
