package com.dbank.account.query;

import lombok.Value;

@Value
public class FindAccountQuery {
    private final String mobileNumber;
}
