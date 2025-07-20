package com.dbank.account.command.event;

import lombok.Data;

@Data
public class AccountDeletedEvent {

    private Long accountNumber;
    private boolean activeSw;

}