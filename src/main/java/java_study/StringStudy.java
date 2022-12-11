package java_study;

public class StringStudy {
	
	public static void main(String[] args) {
		stringBuilder1();
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
	

}
