package com.fileoperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileOperations {

	public static void createMainFolderIfNotPresent(String folderName) {
		File file = new File(folderName);

		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static void displayAllFiles(String path) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		Collections.sort(filesList);

		for (File file : filesList) {
			System.out.println("File name: " + file.getName());
		}

	}

	public static void createFile(String fileToAdd) {
		FileOperations.createMainFolderIfNotPresent("main");
		Path path = Paths.get("./main/" + fileToAdd);

		try {
			Path p = Files.createFile(path);
			System.out.println("File created at path: " + p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void searchFile(String path, String fileName) {

		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		boolean fileFound = false;

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().equals(fileName)) {
					fileFound = true;
					System.out.println(file + " founded at path " + file.getAbsolutePath());
				}
			}
		}
		if(!fileFound) {
			System.out.println("File not found, please give correct file name");
		}


	}

	public static void deleteFile(String path, String fileName) {

		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().equals(fileName)) {
					if (file.delete()) {
						System.out.println(file + " deleted successfully");
					} else {
						System.out.println("Failed to delete " + file);
					}
				}
			}
		}

	}
}
