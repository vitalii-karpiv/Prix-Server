package com.vka.prix.unit.service;

import com.vka.prix.api.dto.AccountCreateDtoIn;
import com.vka.prix.api.dto.AccountCreateDtoOut;
import com.vka.prix.domain.Account;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateAccountTest {

  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    accountService = new AccountService(accountRepository);
  }

  @Test
  void testCreateHDS() {
    // given
    Long accountId = 1L;
    AccountCreateDtoIn dtoIn = new AccountCreateDtoIn(1000.0, "blue", "USD", "Checking", "Asset");
    Account account = new Account(accountId, 1000.0, "blue", "USD", "Checking", "Asset");

    // when
    when(accountRepository.save(any())).thenReturn(account);
    AccountCreateDtoOut dtoOut = accountService.createAccount(dtoIn);

    // then
    assertNotNull(dtoOut.getErrorMap());
    assertTrue(dtoOut.getErrorMap().isEmpty());
    assertEquals(accountId, dtoOut.getId());
    assertEquals(1000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("USD", dtoOut.getCurrency());
    assertEquals("Checking", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }
}

