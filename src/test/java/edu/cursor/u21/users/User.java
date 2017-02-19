package edu.cursor.u21.users;

import edu.cursor.u21.users.BankClient.BankClient;

import java.util.HashMap;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
public interface User {
    public void startSession(HashMap<String, BankClient> usersList);
}
