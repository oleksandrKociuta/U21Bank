package edu.cursor.u21.bankSystem.SystemAccounts;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Oleksandr on 17.02.2017.
 */

@Getter
@Setter
public class Transfer implements DoAccount{

    private static Transfer instance;
    private int uah;
    private int usd;
    private int pln;
    private int eur;

    private Transfer(){
    }

    public static Transfer getInstance(){
        if(instance==null){
            instance = new Transfer();
        }
        return instance;
    }

    @Override
    public void getAmountOfMoney() {
        System.out.println("In transfer account bank have:\n"+uah+" UAH\n"+usd+" USD\n"+pln+" PLN\n"+eur+" EUR");
    }
}
