package edu.cursor.u21.util;

/**
 * Created by Саша on 12.02.2017.
 */
public interface MagicConstantsInterface {

    int hexadecimalNumber = 32;
    int hashByte = 16;
    int minLengthPassword = 5;
    int maxLengthPassword = 15;
    int adultHood = 17;
    String dayOfBirthReg = "^\\d{2}-\\d{2}-\\d{4}$";
    String telephoneNumberReg = "^(\\+?\\d{12)|\\d{10}$";
    String passportReg = "^[A-Z]{2}\\d{6}$";
    String adminClass = "Admin";
    String bankClientClass = "BankClient";
    String fileFormat = ".md";
    int minLengthSalt=8;
    int maxLengthSalt=18;
    int one=1;
    int asciiMaxValue=126;
    int asciiMinValue=33;
    String usersFilePath = "Users.md";
    String BankFilePath = "BankAccount.md";
    int asciiMaxNumber=57;
    int asciiMinNumber=48;
}

