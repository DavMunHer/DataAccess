package org.example.serializable;

import java.io.*;

public class Main {
    public static void serializeData() {
        Alumno al1 = new Alumno("Name1", "234567", 20);
        Alumno al2 = new Alumno("Name2", "583489", 32);

        Grupo g1 = new Grupo("Grupito wazaa");

        g1.addAlumno(al1);
        g1.addAlumno(al2);
        File outputDataFile = new File("/home/davmunher/ejemplo/data.dat");
        try {
            FileOutputStream fos = new FileOutputStream(outputDataFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(g1);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeData() {
        File inputDataFile = new File("/home/davmunher/ejemplo/data.dat");

        try {
            FileInputStream fis = new FileInputStream(inputDataFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Grupo g1 = (Grupo) ois.readObject();
            g1.listarAlumnos();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
