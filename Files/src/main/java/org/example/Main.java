package org.example;

import java.io.*;
import java.util.List;

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

    /*
    4. Create a method that allows you to remove all occurrences of a given word in a
    text file. This code will automatically produce a new file with the following
    nomenclature: if the input file is called file.txt, the generated file will be called
    file_2.txt.
     */
    public static void removeWord(String filePath, String wordToRemove) {
        File f = new File(filePath);

        if (!f.exists()) {
            System.out.println("The file path is not valid!");
            return;
        }
        int dotPosition = f.getPath().indexOf('.');
        String outputFileName = f.getPath().substring(0, dotPosition) + "_2.txt";
        File outputFile = new File(outputFileName);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                String[] newLine = null;
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(wordToRemove)) {
                        words[i] = "";
                    }
                }
                newLine = words;
                for (int i = 0; i < newLine.length; i++) {
                    if (newLine[i] != "") {
                        bw.write(newLine[i] + " ");
                    }
                }
                bw.write("\n");
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    5. Create a method that encrypts and another that decrypts the content of a text file
    using Caesar cipher. Caesar cipher is a type of substitution cipher in which
    each letter in the text is shifted a certain number of places in the alphabet. For example,
    with a shift of 2, “A” would be replaced by “C”, “B” would become “D”. With
    a shift of 5, “C” would be replaced by “H”, “E” would become “J”, etc.
     */
    public static void encriptFile(String filePath) {
        File f = new File(filePath);

        if (!f.exists()) {
            System.out.println("The input file path does not correspond to an actual file!");
            return;
        }
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;


        int dotPosition = f.getPath().indexOf('.');
        String outputFileName = f.getPath().substring(0, dotPosition) + "_2.txt";
        File outputFile = new File(outputFileName);

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            fw = new FileWriter(outputFile);
            bw = new BufferedWriter(fw);
            int currentChar;

            while ((currentChar = br.read()) != -1) {
                int charToWrite = currentChar + 2;
                // Displaying the enter and the space as usual (evading encryption for this two chars)
                if (currentChar == 10) {
                    bw.write("\n");
                } else if (currentChar == 32) {
                    bw.write(" ");
                } else {
                    bw.write(charToWrite);
                }
            }
            br.close();
            fr.close();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    6. Create a method that receives a text file and modifies its content so that every
    word in the file begins with a capital letter.
     */
    public static void capitalizeText(String filePath) {
        File f = new File(filePath);

        if (!f.exists()) {
            System.out.println("Please enter a valid file path! Could not find any file in the inputted path");
        }

        int dotPosition = f.getPath().indexOf('.');
        String outputFileName = f.getPath().substring(0, dotPosition) + "_2.txt.tmp";
        File tempFile = new File(outputFileName);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(tempFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length; i++) {
                    words[i] = (words[i].charAt(0) + "").toUpperCase() + words[i].substring(1);
                    bw.write(words[i] + " ");
                }
                bw.write("\n");
            }

            bw.close();
            fw.close();
            br.close();
            fr.close();

            // We need to delete the previous file and replace it by a new one, since we should not create a FileWriter while the file is already being read
            f.delete();
            tempFile.renameTo(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    7. Create a method that receives two text files and combines the contents of both files.
    To do this, a new file will be created where one word from each file must be added consecutively
    as long as there are words in each file. If a file runs out of words, the words from the other file must be added.
    The result must be a string with the words from both files combined.
     */
    public static void combineContent(String firstFilePath, String secondFilePath) {
        File f1 = new File(firstFilePath);
        File f2 = null;
        File outputFile = null;
        FileReader fr1 = null;
        FileReader fr2 = null;
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        if (!f1.exists()) {
            System.out.println("The first file path is not valid!");
            return;
        }

        f2 = new File(secondFilePath);
        if (!f2.exists()) {
            System.out.println("The second file path is not valid!");
            return;
        }

        outputFile = new File(f1.getPath().substring(0, f1.getPath().indexOf('.')) + f2.getName());

        try {
            fr1 = new FileReader(f1);
            fr2 = new FileReader(f2);
            br1 = new BufferedReader(fr1);
            br2 = new BufferedReader(fr2);

            fw = new FileWriter(outputFile);
            bw = new BufferedWriter(fw);

            int fileOneChar = br1.read();
            int fileTwoChar = br2.read();

            while ((fileOneChar != -1) || (fileTwoChar != -1)) {
                String word1 = "";

                while (fileOneChar != -1) {
                    if (fileOneChar != 32) {
                        word1 += (char) fileOneChar;
                    } else {
                        break;
                    }
                    fileOneChar = br1.read();
                }

                String word2 = "";
                while (fileTwoChar != -1) {
                    if (fileTwoChar != 32) {
                        word2 += (char) fileTwoChar;
                    } else {
                        break;
                    }
                    fileTwoChar = br2.read();
                }

                bw.write(word1 + " " + word2 + " ");
                word1 = "";
                word2 = "";
                fileOneChar = br1.read();
                fileTwoChar = br2.read();
            }
            br2.close();
            br1.close();
            fr2.close();
            fr1.close();
            bw.close();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}