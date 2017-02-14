package edu.cursor.u21.users.Admin;

import edu.cursor.u21.Utils.MagicConstantsInterface;
import edu.cursor.u21.Utils.Read;
import edu.cursor.u21.users.BankClient.BankClient;

import java.util.ArrayList;
class AdminMethods {
   static void displayListOfUsersID(ArrayList<BankClient> listOfUsers) {
        listOfUsers.forEach(
                (BankClient user) -> System.out.println(user.getId()));
    }
    static void filterByAge(int age, ArrayList<BankClient> listOfUsers){
        listOfUsers.stream().filter(
                (BankClient bankClient) -> bankClient.getAge()==age)
                .forEach(System.out::println);
    }
     public static void main(String[] args) {
//        ArrayList<Admin> arrayList = new ArrayList<>();
//        arrayList.add(new Admin("login", "pass", 152));
//        arrayList.add(new Admin("login1", "pass1", 153));
//        arrayList.add(new Admin("login2", "pass2", 154));
//        arrayList.add(new Admin("login3", "pass3", 155));
//        arrayList.add(new Admin("login4", "pass4", 156));
//        Write.writeFile(arrayList);
        ArrayList<BankClient> arrayList = Read.readFile(MagicConstantsInterface.usersFilePath);
        arrayList.forEach(user -> System.out.println(user.getLogin()));
    }
}
