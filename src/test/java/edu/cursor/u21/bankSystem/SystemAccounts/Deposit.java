package edu.cursor.u21.bankSystem.SystemAccounts;

/**
 * Created by Oleksandr on 17.02.2017.
 */
public class Deposit implements DoAccount{

    private static Deposit instance;
    private int uah;
    private int usd;
    private int pln;
    private int eur;

    private Deposit(){
    }

    public static Deposit getInstance(){
        if(instance==null){
            instance = new Deposit();
        }
        return instance;
    }

    @Override
    public void getAmountOfMoney() {
        System.out.println("In deposit account bank have:\n"+uah+" UAH\n"+usd+" USD\n"+pln+" PLN\n"+eur+" EUR");
    }
}
