package org.example;

import java.io.File;

public class Main {

    /*
    1. Create a method that receives a folder and lists the contents of that folder for those
    files whose extension is .txt. Create an overload so that the method receives the type of
    file to be listed.
    */
    public static void listFiles(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.exists()) {
            System.out.println("The folder does not exist!");
            return;
        }

        File[] files = folder.listFiles((file) -> file.getName().toLowerCase().endsWith("." + "txt"));

        if (files != null && files.length > 0) {
            for (File file: files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found!");
        }
    }

    public static void listFiles(String folderPath, String extension) {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("The specied path does not exist or is not a folder!");
            return;
        }

        File[] files = folder.listFiles((file) -> file.getName().toLowerCase().endsWith("." + extension));

        if (files != null && files.length > 0) {
            for (File f: files) {
                System.out.println(f.getName());
            }
        } else {
            System.out.println("No files match the specified extension!");
        }
    }
    // End of act 1

    /*
    2. ...
     */

}