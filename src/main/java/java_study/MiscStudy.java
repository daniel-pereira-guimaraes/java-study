package java_study;

final public class MiscStudy {
	
	public static void main(String[] args) {
		testGetMethodName();
	}
	
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	private static void testGetMethodName() {
		System.out.println("Method name: " + getMethodName());
	}

}
