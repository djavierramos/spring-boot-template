package es.nextdigital.accounts.infrastructure.apirest.controller;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.nextdigital.accounts.domain.dto.Account;
import es.nextdigital.accounts.domain.dto.PageRequest;
import es.nextdigital.accounts.domain.service.AccountsService;
import es.nextdigital.accounts.infrastructure.apirest.dto.AccountDTO;
import es.nextdigital.accounts.infrastructure.apirest.dto.MovementDTO;
import es.nextdigital.accounts.infrastructure.apirest.dto.PageRequestDTO;
import es.nextdigital.accounts.infrastructure.apirest.mapper.AccountDtoToDomainMapper;
import es.nextdigital.accounts.infrastructure.apirest.mapper.MovementDtoToDomainMapper;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/accounts")
public class AccountsController {
    @Autowired
    AccountsService accountsService; 
    @Autowired
    AccountDtoToDomainMapper accountDtoToDomainMapper;
    @Autowired
    MovementDtoToDomainMapper movementDtoToDomainMapper;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(@RequestParam("customer.id") String customerId) {        
        List<Account> accounts = accountsService.getAccounts(customerId);
        if (accounts.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(accounts.stream().map(accountDtoToDomainMapper::fromDomainToDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{account-id}/movements")
    public ResponseEntity<Page<MovementDTO>> getMovements(@PathParam("account-id") String accountId, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        return ResponseEntity.ok().body(movementDtoToDomainMapper.fromPageInDomainToPageinDTO(accountsService.getAccountMovements(accountId, new PageRequest(page,pageSize))));
    }
    @PostMapping("/{account-id}/movements")
    public ResponseEntity postMovement(@PathParam("account-id") MovementDTO movementDTO,@RequestHeader("PAN") String PAN) {
        return ResponseEntity.ok().build();
    }

}
