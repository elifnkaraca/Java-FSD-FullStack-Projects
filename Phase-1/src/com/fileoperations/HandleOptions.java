package com.fileoperations;

import java.util.Scanner;

public class HandleOptions {

	public static void welcomeScreenOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayMenu();
				int input = sc.nextInt();

				switch (input) {
					case 1:
						FileOperations.displayAllFiles("main");
						break;
					case 2:
						HandleOptions.handleFileMenuOptions();
						break;
					case 3:
						System.out.println("Program exited successfully");
						running = false;
						sc.close();
						System.exit(0);
						break;
					default:
						System.out.println("Please select a valid option");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				welcomeScreenOptions();
			}
		} while (running == true);
	}

	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("main");

				int input = sc.nextInt();
				switch (input) {
					case 1:
						System.out.println("Enter the name of the file");
						String fileToAdd = sc.next();

						FileOperations.createFile(fileToAdd);
						break;
					case 2:
						System.out.println("Enter the name of the file to be deleted from \"main\" folder");
						String fileToDelete = sc.next();

						FileOperations.createMainFolderIfNotPresent("main");
						FileOperations.deleteFile("main", fileToDelete);

						break;
					case 3:
						System.out.println("Enter the name of the file to be searched from \"main\" folder");
						String fileName = sc.next();

						FileOperations.createMainFolderIfNotPresent("main");
						FileOperations.searchFile("main", fileName);
						break;
					case 4:
						return;
					case 5:
						System.out.println("Program exited successfully.");
						running = false;
						sc.close();
						System.exit(0);
					default:
						System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
