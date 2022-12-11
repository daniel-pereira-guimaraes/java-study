package java_study;

public class StringStudy {
	
	public static void main(String[] args) {
		stringBuilder1();
		stringBuilder2();
		concatSpeedTest();
	}
	
	public static void stringBuilder1() {
		MiscStudy.printMethodName();
		StringBuilder sb = new StringBuilder();
		sb.append("Daniel");
		sb.append(" ");
		sb.append("Pereira");
		sb.append(" ");
		sb.append("Guimarães");
		sb.append(", ");
		sb.append(2022);
		sb.append("-");
		sb.append(12);
		sb.append("-");
		sb.append(10);
		System.out.println(sb.toString());
		System.out.println();
	}
	
	public static void stringBuilder2() {
		MiscStudy.printMethodName();
		StringBuilder sb = new StringBuilder();
		sb.append("Daniel")
			.append(" ")
			.append("Pereira")
			.append(" ")
			.append("Guimarães")
			.append(", ")
			.append(2022)
			.append("-")
			.append(12)
			.append("-")
			.append(10);
		System.out.println(sb.toString());
		System.out.println();
	}
	
	private static void concatSpeedTest() {
		
		String s1, s2, s3;
		long t1, t2, t3;
		final int count = 90000;
		System.out.println("Processing...");

		// Concatenation
		s1 = "";
		t1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++)
			s1 += i;
		t1 = System.currentTimeMillis() - t1;
		
		// stringBuffer
		t2 = System.currentTimeMillis();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < count; i++)
			stringBuffer.append(i);
		s2 = stringBuffer.toString();
		t2 = System.currentTimeMillis() - t2;

		
		// StringBuilder
		t3 = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++)
			stringBuilder.append(i);
		s3 = stringBuilder.toString();
		t3 = System.currentTimeMillis() - t3;

		System.out.println("s1.length: " + s1.length());
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		System.out.println("Concatenation: " + t1 + "ms");
		System.out.println("StringBuffer: " + t2 + "ms");
		System.out.println("StringBuilder: " + t3 + "ms");
		System.out.println();
	}

}
