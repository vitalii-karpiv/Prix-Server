package com.vka.prix.unit.service.account;

import com.vka.prix.api.dto.account.AccountDeleteDtoIn;
import com.vka.prix.api.dto.account.AccountDeleteDtoOut;
import com.vka.prix.repository.AccountRepository;
import com.vka.prix.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeleteAccountTest {

  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    accountService = new AccountService(accountRepository);
  }

  @Test
  void testDeleteAccountById() {
    // given
    Long accountId = 1L;
    AccountDeleteDtoIn dtoIn = new AccountDeleteDtoIn(1L);

    // when
    AccountDeleteDtoOut dtoOut = accountService.deleteAccount(dtoIn);

    // then
    assertNotNull(dtoOut.getErrorMap());
    assertTrue(dtoOut.getErrorMap().isEmpty());
  }
}
