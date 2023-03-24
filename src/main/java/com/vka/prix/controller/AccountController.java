package com.vka.prix.controller;

import com.vka.prix.api.dto.*;
import org.springframework.web.bind.annotation.*;
import com.vka.prix.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{id}")
  public AccountGetDtoOut getAccountById(@PathVariable Long id) {
    return accountService.getAccountById(new AccountGetDtoIn(id));
  }

  @GetMapping
  public AccountListDtoOut listAccounts() {
    return accountService.listAccounts(new AccountListDtoIn());
  }

  @PostMapping
  public AccountCreateDtoOut createAccount(@RequestBody AccountCreateDtoIn dtoIn) {
    return accountService.createAccount(dtoIn);
  }

  @PutMapping
  public AccountPutDtoOut putAccount(@RequestBody AccountPutDtoIn dtoIn) {
    return accountService.putAccount(dtoIn);
  }

  @PatchMapping
  public AccountPatchDtoOut patchAccount(@RequestBody AccountPatchDtoIn dtoIn) {
    return accountService.patchAccount(dtoIn);
  }

  @DeleteMapping("/{id}")
  public void deleteAccount(@PathVariable Long id) {
    accountService.deleteAccount(new AccountDeleteDtoIn(id));
  }

}
