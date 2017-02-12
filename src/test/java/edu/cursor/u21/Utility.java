package edu.cursor.u21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public static String checkForUniqueness(String seriesOfPassport) {
        File file = new File("C://User.md");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String current;
            boolean everythingIsOK;
            while ((current = br.readLine()) != null) {
                if (current.equals(seriesOfPassport)) {
                    everythingIsOK = false;
                    System.out.println("The user of with such  data already exist.\n" +
                            "Please check your data!");
                    System.out.println("\nDo you want to continue?? (yes,no)");
                    String startOver = input.nextLine();
                    if (startOver.equals("no")) {
                        System.out.println("Bye");
                    } else {
                        System.out.println("Enter data series of passport:");
                        checkForUniqueness(input1.next());
                    }
                }
            }
        } catch (Exception e) {
            log.error("An error in the input data", e);
        }
        return seriesOfPassport;
    }
}
