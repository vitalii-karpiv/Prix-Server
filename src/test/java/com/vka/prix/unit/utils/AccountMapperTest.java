package com.vka.prix.unit.utils;

import com.vka.prix.api.dto.account.*;
import com.vka.prix.domain.Account;
import com.vka.prix.utils.AccountMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountMapperTest {

  private final AccountMapper mapper = AccountMapper.INSTANCE;

  @Test
  void testAccountToGetDto() {
    // given
    Account account = new Account(1L, 1000.0, "red", "USD", "Checking", "Asset");

    // when
    AccountGetDtoOut dtoOut = mapper.accountToGetDto(account);

    // then
    assertNotNull(dtoOut);
    assertEquals(1L, dtoOut.getId());
    assertEquals(1000.0, dtoOut.getBalance());
    assertEquals("red", dtoOut.getColor());
    assertEquals("USD", dtoOut.getCurrency());
    assertEquals("Checking", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testAccountToListDto() {
    // given
    List<Account> accountList = Arrays.asList(new Account(1L, 1000.0, "red", "USD", "Checking", "Asset"));

    // when
    List<AccountGetDtoOut> dtoOut = mapper.accountToListDto(accountList);

    // then
    assertNotNull(dtoOut);
    AccountGetDtoOut dtoItem = dtoOut.get(0);
    assertEquals(1L, dtoItem.getId());
    assertEquals(1000.0, dtoItem.getBalance());
    assertEquals("red", dtoItem.getColor());
    assertEquals("USD", dtoItem.getCurrency());
    assertEquals("Checking", dtoItem.getName());
    assertEquals("Asset", dtoItem.getType());
  }

  @Test
  void testAccountToCreateDto() {
    // given
    Account account = new Account(null, 2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    AccountCreateDtoOut dtoOut = mapper.accountToCreateDto(account);

    // then
    assertNotNull(dtoOut);
    assertNull(dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testAccountToPutDto() {
    // given
    Account account = new Account(2L, 2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    AccountPutDtoOut dtoOut = mapper.accountToPutDto(account);

    // then
    assertNotNull(dtoOut);
    assertEquals(2L, dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testAccountToPatchDto() {
    // given
    Account account = new Account(3L, 2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    AccountPatchDtoOut dtoOut = mapper.accountToPatchDto(account);

    // then
    assertNotNull(dtoOut);
    assertEquals(3L, dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testCreateDtoToAccount() {
    // given
    AccountCreateDtoIn accountDto = new AccountCreateDtoIn(2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    Account dtoOut = mapper.dtoToAccount(accountDto);

    // then
    assertNotNull(dtoOut);
    assertNull(dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testPutDtoToAccount() {
    // given
    AccountPutDtoIn accountDto = new AccountPutDtoIn(1L, 2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    Account dtoOut = mapper.dtoToAccount(accountDto);

    // then
    assertNotNull(dtoOut);
    assertEquals(1L, dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }

  @Test
  void testPatchDtoToAccount() {
    // given
    AccountPatchDtoIn accountDto = new AccountPatchDtoIn(1L, 2000.0, "blue", "EUR", "Savings", "Asset");

    // when
    Account dtoOut = mapper.dtoToAccount(accountDto);

    // then
    assertNotNull(dtoOut);
    assertEquals(1L, dtoOut.getId());
    assertEquals(2000.0, dtoOut.getBalance());
    assertEquals("blue", dtoOut.getColor());
    assertEquals("EUR", dtoOut.getCurrency());
    assertEquals("Savings", dtoOut.getName());
    assertEquals("Asset", dtoOut.getType());
  }
}