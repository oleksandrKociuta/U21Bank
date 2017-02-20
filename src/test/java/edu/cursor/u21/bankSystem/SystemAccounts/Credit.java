package edu.cursor.u21.bankSystem.SystemAccounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Oleksandr on 17.02.2017.
 */

@Getter
@Setter
public class Credit implements Serializable, DoAccount {

    //private static Credit instance;
    private int uah;
    private int usd;
    private int pln;
    private int eur;

    public Credit(){
    }

//    public static Credit getInstance(){
//        if(instance==null){
//            instance = new Credit();
//        }
//        return instance;
//    }


    @Override
    public void getAmountOfMoney() {
        System.out.println("In credit account bank have:\n"+uah+" UAH\n"+usd+" USD\n"+pln+" PLN\n"+eur+" EUR");
    }
}
