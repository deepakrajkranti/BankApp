package com.dbank.account.query.controller;

import com.dbank.account.dto.AccountsDto;
import com.dbank.account.query.FindAccountQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountsQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("/fetch")
    public ResponseEntity<AccountsDto> fetchAccountDetails(@RequestParam("mobileNumber") String mobileNumber) {
        FindAccountQuery findAccountQuery = new FindAccountQuery(mobileNumber);
        AccountsDto customer = queryGateway.query(findAccountQuery, ResponseTypes.instanceOf(AccountsDto.class)).join();
        return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(customer);
    }

}
