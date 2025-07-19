package com.dbank.account.controller;

import com.dbank.common.dto.ErrorResponsedto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
    // Define your endpoints here


     @GetMapping
     public ResponseEntity<?> getAllAccounts() {
      //   return ResponseEntity.ok("HELLO FROM ACCOUNTS MICROSERVICE");
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                 new ErrorResponsedto(
                         "/api/v1/accounts",
                         HttpStatus.INTERNAL_SERVER_ERROR,
                         "Internal Server Error",
                         LocalDateTime.now()
                 ));

     }

    // Add more endpoints as needed

}
