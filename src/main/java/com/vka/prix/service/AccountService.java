package com.vka.prix.service;

import com.vka.prix.api.dto.*;
import com.vka.prix.domain.Account;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.utils.AccountMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountService {

  private static final AccountMapper accountMapper = AccountMapper.INSTANCE;

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public AccountGetDtoOut getAccountById(AccountGetDtoIn dtoIn) {
    // TODO: validation goes here.
    Optional<Account> account = accountRepository.findById(dtoIn.getId());
    // TODO: throw custom error
    return accountMapper.accountToGetDto(account.orElseThrow());
  }

  public AccountListDtoOut listAccounts(AccountListDtoIn dtoIn) {
    // TODO: validation goes here.
    // TODO: filters and pageable
    List<Account> accountList = accountRepository.findAll();
    return AccountListDtoOut
            .builder()
            .accountList(accountMapper.accountToListDto(accountList))
            .build();
  }

  public AccountCreateDtoOut createAccount(AccountCreateDtoIn dtoIn) {
    // TODO: validation goes here.
    Account account = accountRepository.save(accountMapper.dtoToAccount(dtoIn));
    return accountMapper.accountToCreateDto(account);
  }

  public AccountPutDtoOut putAccount(AccountPutDtoIn dtoIn) {
    // TODO: validation goes here.
    Account account = accountRepository.save(accountMapper.dtoToAccount(dtoIn));
    return accountMapper.accountToPutDto(account);
  }

  public AccountPatchDtoOut patchAccount(AccountPatchDtoIn dtoIn) {
    // TODO: validation goes here.
    // TODO: fetch old account
    // TODO: update document
    Account account = accountRepository.save(accountMapper.dtoToAccount(dtoIn));
    return accountMapper.accountToPatchDto(account);
  }

  public AccountDeleteDtoOut deleteAccount(AccountDeleteDtoIn dtoIn) {
    // TODO: validation goes here.
    accountRepository.deleteById(dtoIn.getId());
    return new AccountDeleteDtoOut();
  }

}
