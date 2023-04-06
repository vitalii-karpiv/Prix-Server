package com.vka.prix.unit.service;

import com.vka.prix.api.dto.account.AccountGetDtoIn;
import com.vka.prix.api.dto.account.AccountGetDtoOut;
import com.vka.prix.domain.Account;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.service.AccountService;
import com.vka.prix.utils.AccountMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetAccountTest {

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
  void testGetAccountById() {
    // given
    Long accountId = 1L;
    AccountGetDtoIn dtoIn = new AccountGetDtoIn(accountId);
    Account account = new Account(accountId, 1000.0, "red", "USD", "Checking", "Asset");

    // when
    when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
    AccountGetDtoOut dtoOut = accountService.getAccountById(dtoIn);

    // then
    assertNotNull(dtoOut.getErrorMap());
    assertTrue(dtoOut.getErrorMap().isEmpty());
    assertEquals(accountId, dtoOut.getId());
    assertEquals(1000.0, dtoOut.getBalance());
    assertEquals("red", dtoOut.getColor());
    assertEquals("USD", dtoOut.getCurrency());
    assertEquals("Checking", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }
}
