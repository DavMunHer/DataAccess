package org.example.jsonDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonCsv {

    public static void readJsonCsv(String jsonFilePath, String outputFilePath) {
        File f = new File(jsonFilePath);

        if (!f.exists()) {
            System.out.println("The specified path does not match with any file!");
            return;
        }

        if (!f.getPath().endsWith(".json")) {
            System.out.println("The specified file is not a JSON file!");
            return;
        }
        if (!outputFilePath.endsWith(".csv")) {
            outputFilePath += ".csv";
        }

        File outputFile = new File(outputFilePath);

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            fw = new FileWriter(outputFile);
            bw = new BufferedWriter(fw);

            String line = br.readLine();

            ObjectMapper om = new ObjectMapper();
            Object jsonData = om.readValue(line, Object.class);
            List<Object> jsonDataDeserialized = (List<Object>) jsonData;

            for (int i = 0; i < jsonDataDeserialized.size(); i++) {
                Map<String, String> row = (Map<String, String>) jsonDataDeserialized.get(i);
                bw.write(i + "," + row.get("English") + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
