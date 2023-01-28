package com.fileoperations;

public class FileOperationsMain {

    public static void main(String[] args) {

        FileOperations.createMainFolderIfNotPresent("main");

        MenuOptions.printWelcomeScreen();

    }
}
