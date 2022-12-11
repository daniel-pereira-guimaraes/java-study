package java_study;

import java.io.IOException;

public class ConsoleStudy {

	public static void main(String[] args) {
		pressAnyKeyToContinue();
	}
	
	private static void pressAnyKeyToContinue() {
		MiscStudy.printMethodName();
		System.out.print("Press any key to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done!");
		System.out.println();
	}

}
