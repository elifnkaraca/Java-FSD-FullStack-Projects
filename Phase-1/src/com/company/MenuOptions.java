package com.company;

public class MenuOptions {

	public static void printWelcomeScreen() {
		System.out.println("Welcome Locked.me Java FSD Project which is developed by Elif!");
		displayMenu();
		HandleOptions.welcomeScreenOptions();

	}

	public static void displayMenu() {
		String menu = "\n\n Select any option number from below and press enter\n\n"
				+ "1) Retrieve all files inside \"main\" folder\n" + "2) Display menu for file operations\n"
				+ "3) Exit program\n";
		System.out.println(menu);

	}
	public static void displayFileMenuOptions() {
		String fileMenu = "\n\n Select any option number from below and press enter\n\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show previous menu\n" + "5) Exit program\n";

		System.out.println(fileMenu);
	}
}
