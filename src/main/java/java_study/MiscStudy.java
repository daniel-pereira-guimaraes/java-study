package java_study;

final public class MiscStudy {
	
	public static void main(String[] args) {
		testGetMethodName();
		printMethodName();
	}
	
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	public static void printMethodName() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("--- " + methodName + " ---");
	}
	
	private static void testGetMethodName() {
		System.out.println("Method name: " + getMethodName());
	}
	
}
