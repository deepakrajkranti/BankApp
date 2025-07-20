package com.dbank.account.service;

import com.dbank.account.command.event.AccountUpdatedEvent;
import com.dbank.account.dto.AccountsDto;
import com.dbank.account.entity.Accounts;

public interface IAccountsService {
    /**
     *
     * @param account - Input Mobile Number
     */
    void createAccount(Accounts account);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    AccountsDto fetchAccount(String mobileNumber);

    /**
     *
     * @param event - AccountUpdatedEvent Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(AccountUpdatedEvent event);

    /**
     *
     * @param accountNumber - Input Account Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(Long accountNumber);

}
