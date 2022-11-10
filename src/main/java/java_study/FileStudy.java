package java_study;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileStudy {
	
	private static final String TEXT_FILE_PATH = "C:\\temp\\text.txt"; 

	public static void main(String[] args) throws IOException {
		readTextFileWithScanner();
	}
	
	private static void readTextFileWithScanner() throws IOException {
		File file = new File(TEXT_FILE_PATH);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());
		} 
		finally {
			if (scanner != null)
				scanner.close();
		}
	}

}
