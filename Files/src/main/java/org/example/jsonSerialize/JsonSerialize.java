package org.example.jsonSerialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonSerialize {
    public static void serializeCar(Car c, String outputFilePath) {
        if (!outputFilePath.endsWith(".json")) {
            outputFilePath += ".json";
        }

        File f = new File(outputFilePath);


        ObjectMapper om = new ObjectMapper();
        try {
            String jsonString = om.writeValueAsString(c);
            writeInFile(f, jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeCars(List<Car> cars, @NotNull String outputFilePath) {
        if (!outputFilePath.endsWith(".json")) {
            outputFilePath += ".json";
        }

        File f = new File(outputFilePath);

        ObjectMapper om = new ObjectMapper();
        try {
            String finalString = om.writeValueAsString(cars);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(finalString);

            bw.close();
            fw.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeInFile(File f, String textToWrite) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(textToWrite);

        bw.close();
        fw.close();
    }
}
