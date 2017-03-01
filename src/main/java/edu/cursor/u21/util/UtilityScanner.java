package edu.cursor.u21.util;

import java.util.Scanner;

/**
 * Created by Саша on 09.02.2017.
 */
public class UtilityScanner {

    public static Scanner sc = new Scanner(System.in);

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong choice, repeat:");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
    public static int scanNumberFromZeroToThree() {
        int n = Utility.getInt();
        while (!(n == 0 | n ==  1 | n== 2 |n== 3)) {
            System.out.println("Enter number from 0 to 3");
            n = Utility.getInt();
        }
        return n;
    }
}
