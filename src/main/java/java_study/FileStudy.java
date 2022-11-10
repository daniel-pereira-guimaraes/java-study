package java_study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStudy {
	
	private static final String TEXT_FILE_PATH = "C:\\temp\\text.txt"; 

	public static void main(String[] args) throws IOException {
		readTextFileWithScanner1();
		readTextFileWithScanner2();
		readTextFileWithBufferedReader1();
		readTextFileWithBufferedReader2();
	}
	
	private static void readTextFileWithScanner1() throws IOException {
		System.out.println("--- readTextFileWithScanner1 ---");
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
	
	private static void readTextFileWithScanner2() throws IOException {
		System.out.println("--- readTextFileWithScanner2 ---");
		try (Scanner scanner = new Scanner(new File(TEXT_FILE_PATH))) {
			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());
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
	
	private static void readTextFileWithBufferedReader2() throws IOException {
		System.out.println("--- readTextFileWithBufferedReader2 ---");
		try (BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE_PATH))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		System.out.println();
	}

}
