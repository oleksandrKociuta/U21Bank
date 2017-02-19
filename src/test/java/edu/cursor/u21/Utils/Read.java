package edu.cursor.u21.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Read {
    private Read() {
        throw new IllegalStateException();
    }

    public static HashMap readFile(String path) {
        HashMap hashMap = new HashMap();

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
        while (fileInputStream.available() >1){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            hashMap = (HashMap) objectInputStream.readObject();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}