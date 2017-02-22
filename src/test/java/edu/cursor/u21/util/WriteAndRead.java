package edu.cursor.u21.util;

import edu.cursor.u21.users.bankClient.BankClient;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uiv on 12/8/16.
 */
public class WriteAndRead {

    private WriteAndRead() {
        throw new IllegalStateException();
    }

    public static void writeBankFile(Map list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(MagicConstantsInterface.USERS_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.out.println("Something went wrong: ");
            e.printStackTrace();
        }
    }

    public static Map<String, BankClient> readBankFile() {
        Map<String, BankClient> list = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MagicConstantsInterface.USERS_FILE_PATH))) {
            list = (Map<String, BankClient>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("DB is corrupted !!");
            e.printStackTrace();
        }
        if (list == null) {
            list = new HashMap<>();
        }
        return list;
    }
}























