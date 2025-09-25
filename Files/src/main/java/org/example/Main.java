package org.example;

import java.io.*;

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
            for (File file : files) {
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
            for (File f : files) {
                System.out.println(f.getName());
            }
        } else {
            System.out.println("No files match the specified extension!");
        }
    }
    // End of act 1

    /*
    2. Create a method that must create n files, name(1).txt, name(2).txt, …, name(n).txt
    in the folder requested by the user. Inside each file, the phrase
    ‘This is the file name(n).txt’ must be written.
     */
    public static void createAndWriteFiles(String folderPath, int filesNumber) {
        File folder = new File(folderPath);


        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("The input path does not exist or is not a directory");
            return;
        }

        for (int i = 1; i <= filesNumber; i++) {
            File newFile = new File(folderPath + i + ".txt");
            try {
                boolean success = newFile.createNewFile();
                if (success) {
                    FileWriter fw = new FileWriter(newFile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("This is the file " + newFile.getName());
                    bw.close();
                    fw.close();
                } else {
                    System.out.println("File" + newFile.getName() + " already exists!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    3. Create a method that allows you to search for words in a text file.
    The number of occurrences of that word should be displayed. Use a buffer for reading.
    The method should be named `findword`.
     */
    public static int findWord(String filePath, String wordToFind) {
        File f = new File(filePath);

        if (!f.exists()) {
            System.out.println("The file does not exist!");
            return -1;
        }

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int occurrences = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(wordToFind)) {
                        occurrences++;
                    }
                }
            }
            System.out.println("Found " + occurrences + " occurrences of the word " + wordToFind);
            return occurrences;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


}