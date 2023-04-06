package com.vka.prix.controller;

import com.vka.prix.api.dto.accountHolder.*;
import com.vka.prix.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accountHolders")
@RequiredArgsConstructor
public class AccountHolderController {

  private final AccountHolderService accountHolderService;


  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderGetDtoOut getAccountById(@PathVariable Long id) {
    return accountHolderService.getAccountHolderById(new AccountHolderGetDtoIn(id));
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderListDtoOut listAccounts() {
    return accountHolderService.listAccountHolders(new AccountHolderListDtoIn());
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public AccountHolderCreateDtoOut createAccount(@RequestBody AccountHolderCreateDtoIn dtoIn) {
    return accountHolderService.createAccountHolder(dtoIn);
  }

  @PatchMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderUpdateDtoOut updateAccountHolder(@RequestBody AccountHolderUpdateDtoIn dtoIn) {
    return accountHolderService.updateAccountHolder(dtoIn);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public AccountHolderDeleteDtoOut deleteAccount(@PathVariable Long id) {
    return accountHolderService.deleteAccountHolder(new AccountHolderDeleteDtoIn(id));
  }
}
