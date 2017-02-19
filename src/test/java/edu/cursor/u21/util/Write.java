package edu.cursor.u21.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by uiv on 12/8/16.
 */
public class Write {

    private Write() {
        throw new IllegalStateException();
    }

    public static void writeFile(HashMap adminList) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(MagicConstantsInterface.usersFilePath, false);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
             objectOutputStream.writeObject(adminList);
        } catch (IOException e) {
            System.out.println("Something went wrong: ");
            e.printStackTrace();
        }
    }
}























