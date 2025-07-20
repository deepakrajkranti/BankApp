package com.dbank.account.controller;

import com.dbank.account.service.IAccountsService;
import com.dbank.common.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
    // Define your endpoints here
    private final IAccountsService iAccountsService;

    public AccountsController(IAccountsService iAccountsService) {
        this.iAccountsService = iAccountsService;
    }


     @GetMapping
     public ResponseEntity<?> getAllAccounts() {
      //   return ResponseEntity.ok("HELLO FROM ACCOUNTS MICROSERVICE");
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                 new ErrorResponseDto(
                         "/api/v1/accounts",
                         HttpStatus.INTERNAL_SERVER_ERROR,
                         "Internal Server Error",
                         LocalDateTime.now()
                 ));

     }
//    @PostMapping("/create")
//    public ResponseEntity<ResponseDto> createAccount(@RequestParam("mobileNumber")
//                                                     String mobileNumber) {
//        iAccountsService.createAccount(mobileNumber);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
//    }

    // Add more endpoints as needed

}
