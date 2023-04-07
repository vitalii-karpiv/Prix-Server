package com.vka.prix.service;

import com.vka.prix.api.dto.accountHolder.*;
import com.vka.prix.domain.AccountHolder;
import com.vka.prix.repository.AccountHolderRepository;
import com.vka.prix.utils.AccountHolderMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderService implements UserDetailsService {

  private static final AccountHolderMapper accountHolderMapper = AccountHolderMapper.INSTANCE;

  private final AccountHolderRepository accountHolderRepository;

  public AccountHolderService(AccountHolderRepository accountHolderRepository) {
    this.accountHolderRepository = accountHolderRepository;
  }

  public AccountHolderGetDtoOut getAccountHolderById(AccountHolderGetDtoIn dtoIn) {
    // TODO: validation
    Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findById(dtoIn.getId());
    return accountHolderMapper.accountToGetDto(accountHolderOptional.orElseThrow()); // TODO: custom error
  }

  public AccountHolderListDtoOut listAccountHolders(AccountHolderListDtoIn dtoIn) {
    // TODO: validation
    List<AccountHolder> accountHolderList = accountHolderRepository.findAll();
    return AccountHolderListDtoOut.builder()
            .accountList(accountHolderMapper.accountToListDto(accountHolderList))
            .build();
  }

  public AccountHolderPatchDtoOut patchAccountHolder(AccountHolderPatchDtoIn dtoIn) {
    // TODO: validation
    // TODO: properly update ah
    AccountHolder accountHolder = accountHolderRepository.save(accountHolderMapper.dtoToAccountHolder(dtoIn));
    return accountHolderMapper.accountToPatchDto(accountHolder);
  }

  public AccountHolderPutDtoOut putAccountHolder(AccountHolderPutDtoIn dtoIn) {
    // TODO: validation
    // TODO: properly update ah
    AccountHolder accountHolder = accountHolderRepository.save(accountHolderMapper.dtoToAccountHolder(dtoIn));
    return accountHolderMapper.accountToPutDto(accountHolder);
  }

  public AccountHolderDeleteDtoOut deleteAccountHolder(AccountHolderDeleteDtoIn dtoIn) {
    // TODO: validation
    accountHolderRepository.deleteById(dtoIn.getId());
    return new AccountHolderDeleteDtoOut();
  }

  public AccountHolder getAccountHolderByEmail(String email) {
    // TODO: validation
    Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findByEmail(email);
    return accountHolderOptional.orElseThrow(() -> new RuntimeException("Account holder not found")); // TODO: custom error
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return getAccountHolderByEmail(username);
  }
}
