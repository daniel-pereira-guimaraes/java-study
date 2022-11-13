package java_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStudy {
	
	private static final String TEXT_FILE_PATH = "C:\\temp\\text.txt";
	private static final String TEST_DIR_PATH = "C:\\temp";

	public static void main(String[] args) throws IOException {
		readTextFileWithScanner1();
		readTextFileWithScanner2();
		readTextFileWithBufferedReader1();
		readTextFileWithBufferedReader2();
		writeTextFileWithFileWriter(false);
		writeTextFileWithFileWriter(true);
		writeTextFileWithBufferedWriter(false);
		writeTextFileWithBufferedWriter(true);
		listDirectories();
		listFiles();
		listRecursiveDirectories(TEST_DIR_PATH, 0);
		createDirectory();
	}
	
	private static void readTextFileWithScanner1() throws IOException {
		MiscStudy.printMethodName();
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
		MiscStudy.printMethodName();
		try (Scanner scanner = new Scanner(new File(TEXT_FILE_PATH))) {
			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());
		} 
		System.out.println();
	}

	private static void readTextFileWithBufferedReader1() throws IOException {
		MiscStudy.printMethodName();
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
		MiscStudy.printMethodName();
		try (BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE_PATH))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		System.out.println();
	}
	
	private static void writeTextFileWithFileWriter(final boolean append) throws IOException {
		MiscStudy.printMethodName();
		System.out.println((append ? "Appending to file " : "Creating new file ") + TEXT_FILE_PATH);
		try (FileWriter fw = new FileWriter(TEXT_FILE_PATH, append)) {
			fw.write((append ? "Appended" : "Created") + " by " + MiscStudy.getMethodName() + "\n");
			for (int i = 1; i <= 10; i++) {
				System.out.println("Writing line #" + i);
				fw.write("Line #" + i + "\n");
			}
		}
		System.out.println();
	}
	
	private static void writeTextFileWithBufferedWriter(final boolean append) throws IOException {
		MiscStudy.printMethodName();
		System.out.println((append ? "Appending to file " : "Create new file ") + TEXT_FILE_PATH);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE_PATH, append))) {
			bw.write((append ? "Appended" : "Created") + " by " + MiscStudy.getMethodName());
			bw.newLine();
			for (int i = 1; i <= 10; i++) {
				System.out.println("Writing line #" + i);
				bw.write("Line #" + i);
				bw.newLine();
			}
		}
		System.out.println();
	}
	
	private static void listDirectories() {
		MiscStudy.printMethodName();
		File path = new File(TEST_DIR_PATH);
		if (path.exists()) {
			File[] dirList = path.listFiles(File::isDirectory);
			System.out.println("[" + path.getAbsolutePath() + "] contain " + dirList.length + " directories.");
			for (File dir : dirList)
				System.out.println("\t" + dir.getName());
		} else {
			System.out.println("Path not found: " + path.getAbsolutePath());
		}
		System.out.println();
	}
	
	private static void listFiles() {
		MiscStudy.printMethodName();
		File path = new File(TEST_DIR_PATH);
		if (path.exists()) {
			File[] files = path.listFiles(File::isFile);
			System.out.println("[" + path.getAbsolutePath() + "] contain " + files.length + " files.");
			for (File file : files)
				System.out.println("\t" + file.getAbsolutePath());
		} else {
			System.out.println("Path not found: " + path.getAbsolutePath());
		}
		System.out.println();
	}
	
	private static void listRecursiveDirectories(final String path, int level) {
		level = level < 0 ? 0 : level;
		if (level == 0)
			MiscStudy.printMethodName();
		File dir = new File(path);
		if (dir.exists()) {
			System.out.println(dir.getAbsolutePath());
			File[] subDirList = dir.listFiles(File::isDirectory);
			for (File subDir : subDirList) {
				System.out.println(subDir.getAbsolutePath());
				listRecursiveDirectories(subDir.getAbsolutePath(), level + 1);
			}
		}
		if (level == 0)
			System.out.println();
	}
	
	private static void createDirectory() {
		MiscStudy.printMethodName();
		File dir = new File(TEST_DIR_PATH + "\\subdir");
		if (dir.exists())
			System.out.println("Directory already exists: " + dir.getAbsolutePath());
		else {
			System.out.println("Creating directory: " + dir.getAbsolutePath());
			if (dir.mkdir())
				System.out.println("Directory created successfully.");
			else
				System.out.println("Could not create directory.");
		}
		System.out.println();
	}

}
