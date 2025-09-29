package org.example.jsonDeserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.jsonSerialize.Book;

import java.io.*;
import java.util.List;

public class JSONOps {
    // This class is only being used for Serializing and deserializing the Books

    public static void serializeList(String outputFile) {
        Book b1 = new Book("Title1", "123456789", "Myself", 262, 2022);
        Book b2 = new Book("Title2", "987291739", "Not Myself :(", 156, 2002);

        List<Book> books = List.of(b1, b2);

        File f = new File(outputFile);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            ObjectMapper om = new ObjectMapper();
            String jsonString = om.writeValueAsString(books);

            bw.write(jsonString);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static ArrayNode deserializeList(String inputJsonFile) {
        File f = new File(inputJsonFile);

        if (!f.exists()) {
            System.out.println("The input file does not exist!");
            return null;
        }

        if (!f.getName().endsWith(".json")) {
            System.out.println("The input file is not a json file!");
            return null;
        }

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String jsonLine = br.readLine();

            ObjectMapper om = new ObjectMapper();

            ArrayNode deserializedData = (ArrayNode) om.readTree(jsonLine);

            return deserializedData;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
