package java_study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStudy {
	
	private static final String TEXT_FILE_PATH = "C:\\temp\\text.txt"; 

	public static void main(String[] args) throws IOException {
		readTextFileWithScanner();
		readTextFileWithBufferedReader1();
	}
	
	private static void readTextFileWithScanner() throws IOException {
		System.out.println("--- readTextFileWithScanner ---");
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
		System.out.println();
	}
	
	private static void readTextFileWithBufferedReader1() throws IOException {
		System.out.println("--- readTextFileWithBufferedReader1 ---");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(TEXT_FILE_PATH);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} 
		finally {
			if (bufferedReader != null)
				bufferedReader.close();
			if (fileReader != null)
				fileReader.close();
		}
		System.out.println();
	}

}
