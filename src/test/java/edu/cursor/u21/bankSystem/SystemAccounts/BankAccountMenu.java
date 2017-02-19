package edu.cursor.u21.bankSystem.SystemAccounts;

import edu.cursor.u21.util.Utility;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksandr on 19.02.2017.
 */
public class BankAccountMenu {

    static Map<Character, DoAccount> accountMap = new HashMap<>();

    public static void menu2(){

        accountMap.put('c', Credit.getInstance());
        accountMap.put('d', Deposit.getInstance());
        accountMap.put('t', Transfer.getInstance());

    }

    public static void BankAccountMenu(){
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
