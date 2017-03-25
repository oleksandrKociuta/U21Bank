package edu.cursor.u21.users.Admin;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor
public class AdminMethods implements AdminInterface {

    public void displayListOfUsers() {
//        Session session = SessionFactory.currentSession();
//        Transaction transaction = session.beginTransaction();
//        List<?> listOfUsers = session.createQuery("from BankClient").list();
//        System.out.println(listOfUsers.iterator().next().toString());
//        transaction.commit();
//        SessionFactory.closeSession();
//    }
//
//    public void displayAllUsersAccounts() {
//        String sql = "SELECT * FROM u21bankusers.accounts";
//        iterateAccounts(sql);
//    }
//
//    public void displayUserAccounts(int userId) {
//        String sqlQuery = String.format("SELECT * FROM u21bankusers.accounts WHERE userID =%d", userId);
//        iterateAccounts(sqlQuery);
//    }
//
//    private void iterateAccounts(String sqlQuery) {
//        Session session = SessionFactory.currentSession();
//        Transaction transaction = session.beginTransaction();
//        List<?> listOfAccounts = session.createQuery("from Account").list();
//        session.createFilter(listOfAccounts, sqlQuery);
//        transaction.commit();
//        SessionFactory.closeSession();
    }
}