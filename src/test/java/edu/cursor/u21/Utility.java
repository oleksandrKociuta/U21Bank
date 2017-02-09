package edu.cursor.u21;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.*;

/**
 * Created by Саша on 09.02.2017.
 */
public class Utility extends UtilityScanner{

    Logger log = Logger.getLogger(Utility.class);

    public String getPassword() {

        String password = getStringForPassword();
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error("Unexpected error", e);        }
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashPassword = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashPassword.length() < 32) {
            hashPassword = "0" + hashPassword;
        }
        return hashPassword;
    }

    private static String getStringForPassword() {
        String getPassword = sc.nextLine();
        while (getPassword.length() < 5 || 15 < getPassword.length()) {
            System.out.println("Your password must be 5-15 characters.\n" +
                    "Try again:");
            getPassword = sc.nextLine();
        }
        return getPassword;
    }
}
