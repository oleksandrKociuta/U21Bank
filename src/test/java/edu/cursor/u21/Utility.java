package edu.cursor.u21;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.*;

/**
 * Created by Саша on 09.02.2017.
 */
public class Utility extends UtilityScanner implements MagicConstantsInterface {

    Logger log = Logger.getLogger(Utility.class);

    public String getPassword() {

        String password = getStringForPassword();
        String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        password = password + salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error("Unexpected error", e);
        }
        messageDigest.reset();
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        BigInteger bigInt1 = new BigInteger(1, digest);
        String hashPassword = bigInt1.toString(hashByte);
        while (hashPassword.length() < hexadecimalNumber) {
            hashPassword = "0" + hashPassword;
        }
        return hashPassword;
    }

    private static String getStringForPassword() {
        String getPassword = sc.nextLine();
        while (getPassword.length() < minLengthPassword || maxLengthPassword < getPassword.length()) {
            System.out.println("Your password must be 5-15 characters.\n" +
                    "Try again:");
            getPassword = sc.nextLine();
        }
        return getPassword;
    }
}
