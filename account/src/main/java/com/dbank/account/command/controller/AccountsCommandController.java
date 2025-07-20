package com.dbank.account.command.controller;

import com.dbank.account.command.CreateAccountCommand;
import com.dbank.account.command.DeleteAccountCommand;
import com.dbank.account.command.UpdateAccountCommand;
import com.dbank.account.constants.AccountsConstants;
import com.dbank.account.dto.AccountsDto;
import com.dbank.account.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountsCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestParam("mobileNumber")
                                                    String mobileNumber) {
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        CreateAccountCommand createCommand = CreateAccountCommand.builder()
                .accountNumber(randomAccNumber).mobileNumber(mobileNumber)
                .accountType(AccountsConstants.SAVINGS).branchAddress(AccountsConstants.ADDRESS)
                .activeSw(AccountsConstants.ACTIVE_SW).build();
        commandGateway.sendAndWait(createCommand);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody AccountsDto accountsDto) {
        UpdateAccountCommand updateCommand = UpdateAccountCommand.builder()
                .accountNumber(accountsDto.getAccountNumber()).mobileNumber(accountsDto.getMobileNumber())
                .accountType(accountsDto.getAccountType()).branchAddress(accountsDto.getBranchAddress())
                .activeSw(AccountsConstants.ACTIVE_SW).build();
        commandGateway.sendAndWait(updateCommand);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }

    @PatchMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam("accountNumber") Long accountNumber) {
        DeleteAccountCommand deleteCommand = DeleteAccountCommand.builder()
                .accountNumber(accountNumber).activeSw(AccountsConstants.IN_ACTIVE_SW).build();
        commandGateway.sendAndWait(deleteCommand);
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }

}