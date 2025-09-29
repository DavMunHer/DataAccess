package org.example.jsonDeserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
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

}
