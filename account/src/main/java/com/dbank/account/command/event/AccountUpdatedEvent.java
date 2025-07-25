package com.dbank.account.command.event;

import lombok.Data;

@Data
public class AccountUpdatedEvent {

    private Long accountNumber;
    private String mobileNumber;
    private String accountType;
    private String branchAddress;
    private boolean activeSw;

}