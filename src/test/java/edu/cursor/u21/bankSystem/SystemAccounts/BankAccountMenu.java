package edu.cursor.u21.bankSystem.SystemAccounts;

import edu.cursor.u21.users.BankClient.Accounts.Account;
import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Read;
import edu.cursor.u21.util.Utility;
import edu.cursor.u21.util.Write;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksandr on 19.02.2017.
 */
public class BankAccountMenu {

    public static void BankAccountMenu(){

    HashMap<Character,DoAccount> accountMap = Read.readFile(MagicConstantsInterface.BankFilePath);
        System.out.println("choose bank account: c-credit, d-deposit, t-transfer");
        char ch = Utility.sc.nextLine().toLowerCase().charAt(0);
        while (ch!='c'||ch!='d'||ch!='t'){
            System.out.println("Wrong input, repeat:");
            ch = Utility.sc.nextLine().toLowerCase().charAt(0);
        }
        System.out.println("You choose "+accountMap.get(ch).getClass().getName()+" account.");
        System.out.println("1-print all bank money in accounts, 2-add money to account, 3-take some money from account");
        int key= Utility.getInt();
        switch (key){
            case 1:
                accountMap.get(ch).getAmountOfMoney();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Wrong input, repeat:");
                break;

        }
    }



}
