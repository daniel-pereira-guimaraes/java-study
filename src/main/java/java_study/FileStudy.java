package java_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class FileStudy {

	private static final String TEST_DRIVE_PATH = "C:\\";
	private static final String TEST_DIR_PATH = "C:\\temp";
	private static final String TEXT_FILE_PATH = "C:\\temp\\text.txt";
	private static final String YES = "Yes";
	private static final String NO = "No";

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
		removeDirectory1();
		removeDirectory2();
		printPathInfo(new File(TEST_DRIVE_PATH));
		printPathInfo(new File(TEST_DIR_PATH));
		printPathInfo(new File(TEXT_FILE_PATH));
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
	
	/**
	 * Remove directory, if empty.
	 */
	private static void removeDirectory1() {
		MiscStudy.printMethodName();
		File dir = new File(TEST_DIR_PATH + "\\subdir");
		if (dir.exists()) {
			System.out.println("Removing directory: " + dir.getAbsolutePath());
			if (dir.delete())
				System.out.println("Directory successfully removed.");
			else
				System.out.println("Could not remove directory.");
		} else {
			System.out.println("Directory not exists: " + dir.getAbsolutePath());
		}
		System.out.println();
	}

	/**
	 * Remove directory, even if it is not empty.
	 * @throws IOException
	 */
	private static void removeDirectory2() throws IOException {
		MiscStudy.printMethodName();
		File dir = new File(TEST_DIR_PATH + "\\subdir");
		System.out.println("Removing directory: " + dir.getAbsolutePath());
		try {
			if (!dir.exists())
				throw new IOException("Directory not exists: " + dir.getAbsolutePath());
			FileUtils.deleteDirectory(dir); // Dependency: commons-io
		} 
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	/**
	 * Print file or directory informations.
	 * @param file
	 * @throws IOException 
	 */
	private static void printPathInfo(File file) throws IOException {
		MiscStudy.printMethodName();
		System.out.println("Informations for " + file.getAbsolutePath());
		System.out.println("Exists: " + (file.exists() ? YES : NO));
		System.out.println("Can execute: " + (file.canExecute() ? YES : NO));
		System.out.println("Can read: " + (file.canRead() ? YES : NO));
		System.out.println("Can write: " + (file.canWrite() ? YES : NO));
		System.out.println("Is absolute: " + (file.isAbsolute() ? YES : NO));
		System.out.println("Is directory: " + (file.isDirectory() ? YES : NO));
		System.out.println("Is file: " + (file.isFile() ? YES : NO));
		System.out.println("Is hidden: " + (file.isHidden() ? YES : NO));
		System.out.println("Name: " + file.getName());
		System.out.println("Parent: " + file.getParent());
		System.out.println("Path: " + file.getPath());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Canonical path: " + file.getCanonicalPath());
		System.out.println("Total space: " + file.getTotalSpace());
		System.out.println("Usable space: " + file.getUsableSpace());
		System.out.println("Free space: " + file.getFreeSpace());
		System.out.println();
	}
	
}
