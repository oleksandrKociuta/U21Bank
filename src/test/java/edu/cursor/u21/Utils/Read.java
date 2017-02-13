package edu.cursor.u21.Utils;

import java.io.*;
import java.util.ArrayList;

public class Read {
    private Read() {
        throw new IllegalStateException();
    }

    public static ArrayList readFile(String path) {
        ArrayList list = new ArrayList();

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
        while (fileInputStream.available() >1){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}