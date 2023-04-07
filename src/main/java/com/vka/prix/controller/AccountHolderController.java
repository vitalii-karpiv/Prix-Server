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

  @PatchMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderPatchDtoOut patchAccountHolder(@RequestBody AccountHolderPatchDtoIn dtoIn) {
    return accountHolderService.patchAccountHolder(dtoIn);
  }

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderPutDtoOut putAccountHolder(@RequestBody AccountHolderPutDtoIn dtoIn) {
    return accountHolderService.putAccountHolder(dtoIn);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public AccountHolderDeleteDtoOut deleteAccount(@PathVariable Long id) {
    return accountHolderService.deleteAccountHolder(new AccountHolderDeleteDtoIn(id));
  }
}
