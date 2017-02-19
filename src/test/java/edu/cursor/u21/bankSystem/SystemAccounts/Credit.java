package edu.cursor.u21.bankSystem.SystemAccounts;

/**
 * Created by Oleksandr on 17.02.2017.
 */
public class Credit implements DoAccount {

    private static Credit instance;
    private int uah;
    private int usd;
    private int pln;
    private int eur;

    private Credit(){
    }

    public static Credit getInstance(){
        if(instance==null){
            instance = new Credit();
        }
        return instance;
    }

    @Override
    public void getAmountOfMoney() {
        System.out.println("In credit account bank have:\n"+uah+" UAH\n"+usd+" USD\n"+pln+" PLN\n"+eur+" EUR");
    }
}
