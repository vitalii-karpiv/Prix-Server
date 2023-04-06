package com.vka.prix.controller;

import com.vka.prix.api.dto.account.*;
import org.springframework.http.HttpStatus;
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
  @ResponseStatus(code = HttpStatus.OK)
  public AccountGetDtoOut getAccountById(@PathVariable Long id) {
    return accountService.getAccountById(new AccountGetDtoIn(id));
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountListDtoOut listAccounts() {
    return accountService.listAccounts(new AccountListDtoIn());
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public AccountCreateDtoOut createAccount(@RequestBody AccountCreateDtoIn dtoIn) {
    return accountService.createAccount(dtoIn);
  }

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountPutDtoOut putAccount(@RequestBody AccountPutDtoIn dtoIn) {
    return accountService.putAccount(dtoIn);
  }

  @PatchMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountPatchDtoOut patchAccount(@RequestBody AccountPatchDtoIn dtoIn) {
    return accountService.patchAccount(dtoIn);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public AccountDeleteDtoOut deleteAccount(@PathVariable Long id) {
    return accountService.deleteAccount(new AccountDeleteDtoIn(id));
  }

}
