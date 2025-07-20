package com.dbank.account.dto;

import lombok.Data;

@Data
public class AccountsDto {

    private Long accountNumber;

    private String mobileNumber;

    private String accountType;

    private String branchAddress;

    private boolean activeSw;
}