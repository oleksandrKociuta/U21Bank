package edu.cursor.u21.users.bankClient.Accounts;

import lombok.Getter;

/**
 * Created by vk on 2/28/17.
 */
@Getter
public enum AccountType {
    CREDIT("Credit"),
    DEPOSIT("Deposit"),
    SAVING("Saving"),
    TRANSFER("Transfer");
    private String value;

    AccountType(String value) {
        this.value = value;
    }
}
