package edu.cursor.u21.util;

import java.util.Scanner;

/**
 * Created by Саша on 09.02.2017.
 */
public class UtilityScanner {

    public static Scanner sc = new Scanner(System.in);

    public  static int scanInt(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            System.out.println("Wrong choice, repeat:");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
