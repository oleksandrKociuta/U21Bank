package edu.cursor.u21.bankSystem.SystemAccounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Oleksandr on 17.02.2017.
 */
@Getter
@Setter
public class Deposit implements Serializable, DoAccount{

   //private static Deposit instance;
    private int uah;
    private int usd;
    private int pln;
    private int eur;

    public Deposit(){
    }

//    public static Deposit getInstance(){
//        if(instance==null){
//            instance = new Deposit();
//        }
//        return instance;
//    }

    @Override
    public void getAmountOfMoney() {
        System.out.println("In deposit account bank have:\n"+uah+" UAH\n"+usd+" USD\n"+pln+" PLN\n"+eur+" EUR");
    }
}
