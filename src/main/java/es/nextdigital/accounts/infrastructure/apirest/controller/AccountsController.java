package es.nextdigital.accounts.infrastructure.apirest.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.nextdigital.accounts.infrastructure.apirest.dto.AccountDTO;

@Controller
@RequestMapping("/accounts")
public class AccountsController {
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(@RequestParam("customer.id") String customerId) {
        return ResponseEntity.noContent().build();
    }
}
