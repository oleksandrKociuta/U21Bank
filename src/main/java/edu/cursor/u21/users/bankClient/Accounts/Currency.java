package edu.cursor.u21.users.bankClient.Accounts;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by uiv on 2/15/17.
 */
@Getter
public enum Currency implements Serializable {
    USD(840),
    EUR(978),
    UAH(980),
    PLN(985);
    private int code;

    Currency(int code) {
        this.code = code;
    }
}
