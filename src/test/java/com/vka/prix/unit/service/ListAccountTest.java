package com.vka.prix.unit.service;

import com.vka.prix.api.dto.account.AccountGetDtoOut;
import com.vka.prix.api.dto.account.AccountListDtoIn;
import com.vka.prix.api.dto.account.AccountListDtoOut;
import com.vka.prix.domain.Account;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.service.AccountService;
import com.vka.prix.utils.AccountMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListAccountTest {

  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  private static final AccountMapper accountMapper = AccountMapper.INSTANCE;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    accountService = new AccountService(accountRepository);
  }

  @Test
  void testListAccountById() {
    // given
    Long accountId = 1L;
    AccountListDtoIn dtoIn = new AccountListDtoIn();
    Account account = new Account(accountId, 1000.0, "red", "USD", "Checking", "Asset");

    // when
    when(accountRepository.findAll()).thenReturn(List.of(account));
    AccountListDtoOut dtoOut = accountService.listAccounts(dtoIn);

    // then
    assertNotNull(dtoOut.getErrorMap());
    assertTrue(dtoOut.getErrorMap().isEmpty());
    AccountGetDtoOut accountGetDtoOut = dtoOut.getAccountList().get(0);
    assertEquals(accountId, accountGetDtoOut.getId());
    assertEquals(1000.0, accountGetDtoOut.getBalance());
    assertEquals("red", accountGetDtoOut.getColor());
    assertEquals("USD", accountGetDtoOut.getCurrency());
    assertEquals("Checking", accountGetDtoOut.getName());
    assertEquals("Asset", accountGetDtoOut.getType());
  }
}
