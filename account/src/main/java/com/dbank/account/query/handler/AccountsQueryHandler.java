package com.dbank.account.query.handler;

import com.dbank.account.dto.AccountsDto;
import com.dbank.account.query.FindAccountQuery;
import com.dbank.account.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountsQueryHandler {

    private final IAccountsService iAccountsService;

    @QueryHandler
    public AccountsDto findAccount(FindAccountQuery query) {
        AccountsDto account = iAccountsService.fetchAccount(query.getMobileNumber());
        return account;
    }

}