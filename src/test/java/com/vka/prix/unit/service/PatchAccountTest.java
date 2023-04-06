package com.vka.prix.unit.service;

import com.vka.prix.api.dto.account.AccountPatchDtoIn;
import com.vka.prix.api.dto.account.AccountPatchDtoOut;
import com.vka.prix.domain.Account;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PatchAccountTest {

  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    accountService = new AccountService(accountRepository);
  }

  @Test
  void testPatchHDS() {
    // given
    Long accountId = 1L;
    AccountPatchDtoIn dtoIn = new AccountPatchDtoIn(accountId, 1000.0, "red", "USD", "Checking1", "Asset1");
    Account account = new Account(accountId, 1000.0, "blue", "USD", "Checking", "Asset");
    Account updated = new Account(accountId, 1000.0, "red", "USD", "Checking1", "Asset1");

    // when
    when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
    when(accountRepository.save(any())).thenReturn(updated);
    AccountPatchDtoOut dtoOut = accountService.patchAccount(dtoIn);

    // then
    assertNotNull(dtoOut.getErrorMap());
    assertTrue(dtoOut.getErrorMap().isEmpty());
    assertEquals(accountId, dtoOut.getId());
    assertEquals(1000.0, dtoOut.getBalance());
    assertEquals("red", dtoOut.getColor());
    assertEquals("USD", dtoOut.getCurrency());
    assertEquals("Checking1", dtoOut.getName());
    assertEquals("Asset1", dtoOut.getType());
  }
}
