package java_study;

public class EnumStudy {

	public static void main(String[] args) {
		basicEnumOperations();
		enumWithCustomValues();
		printEnumValues();
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

	
	private static enum YearSeasons {
		SPRING(1),
		SUMMER(2),
		AUTUMN(3),
		WINTER(4);
		
		public int value;

		YearSeasons(int value) {
			this.value = value;
		}
	}
	
	private static void enumWithCustomValues() {
		MiscStudy.printMethodName();
		
		YearSeasons seasons1 = YearSeasons.SPRING;
		YearSeasons seasons2 = YearSeasons.WINTER;
		
		System.out.println("seasons1: " + seasons1);
		System.out.println("seasons2: " + seasons2);

		System.out.println("seasons1.name: " + seasons1.name());
		System.out.println("seasons2.name: " + seasons2.name());
		
		System.out.println("seasons1.value: " + seasons1.value);
		System.out.println("seasons2.value: " + seasons2.value);
		
		System.out.println("seasons1.ordinal(): " + seasons1.ordinal());
		System.out.println("seasons2.ordinal(): " + seasons2.ordinal());
		System.out.println();
	}
	
	private static void printEnumValues() {
		MiscStudy.printMethodName();

		for (YearSeasons seasons : YearSeasons.values())
			System.out.println(seasons);
		
		System.out.println();
	}
	
}


