package com.vka.prix.unit.utils;

import com.vka.prix.api.dto.accountHolder.*;
import com.vka.prix.domain.AccountHolder;
import com.vka.prix.domain.Role;
import com.vka.prix.utils.AccountHolderMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountHolderMapperTest {

    private final AccountHolderMapper mapper = AccountHolderMapper.INSTANCE;

    private final static Long ID = 1L;
    private final static String EMAIL = "testemail@gmail.com";
    private final static String PASSWORD = "1234";

    @Test
    void testAccountHolderHolderToGetDto() {
        // given
        AccountHolder account = new AccountHolder(ID, EMAIL, PASSWORD, Role.USER);

        // when
        AccountHolderGetDtoOut dtoOut = mapper.accountToGetDto(account);

        // then
        assertNotNull(dtoOut);
        assertEquals(ID, dtoOut.getId());
        assertEquals(EMAIL, dtoOut.getEmail());
        assertEquals(PASSWORD, dtoOut.getPassword());
        assertEquals(Role.USER, dtoOut.getRole());
    }

    @Test
    void testAccountHolderToListDto() {
        // given
        List<AccountHolder> accountList = List.of(new AccountHolder(ID, EMAIL, PASSWORD, Role.USER));

        // when
        List<AccountHolderGetDtoOut> dtoOut = mapper.accountToListDto(accountList);

        // then
        assertNotNull(dtoOut);
        AccountHolderGetDtoOut dtoItem = dtoOut.get(0);
        assertNotNull(dtoOut);
        assertEquals(ID, dtoItem.getId());
        assertEquals(EMAIL, dtoItem.getEmail());
        assertEquals(PASSWORD, dtoItem.getPassword());
        assertEquals(Role.USER, dtoItem.getRole());
    }

    @Test
    void testAccountHolderToPutDto() {
        // given
        AccountHolder account = new AccountHolder(ID, EMAIL, PASSWORD, Role.USER);

        // when
        AccountHolderPutDtoOut dtoOut = mapper.accountToPutDto(account);

        // then
        assertNotNull(dtoOut);
        assertEquals(ID, dtoOut.getId());
        assertEquals(EMAIL, dtoOut.getEmail());
        assertEquals(PASSWORD, dtoOut.getPassword());
        assertEquals(Role.USER, dtoOut.getRole());
    }

    @Test
    void testAccountHolderToPatchDto() {
        // given
        AccountHolder account = new AccountHolder(ID, EMAIL, PASSWORD, Role.USER);

        // when
        AccountHolderPatchDtoOut dtoOut = mapper.accountToPatchDto(account);

        // then
        assertNotNull(dtoOut);
        assertEquals(ID, dtoOut.getId());
        assertEquals(EMAIL, dtoOut.getEmail());
        assertEquals(PASSWORD, dtoOut.getPassword());
        assertEquals(Role.USER, dtoOut.getRole());
    }

    @Test
    void testPutDtoToAccountHolder() {
        // given
        AccountHolderPutDtoIn accountDto = new AccountHolderPutDtoIn(ID, EMAIL, PASSWORD, Role.USER);

        // when
        AccountHolder dtoOut = mapper.dtoToAccountHolder(accountDto);

        // then
        assertNotNull(dtoOut);
        assertEquals(ID, dtoOut.getId());
        assertEquals(EMAIL, dtoOut.getEmail());
        assertEquals(PASSWORD, dtoOut.getPassword());
        assertEquals(Role.USER, dtoOut.getRole());
    }

    @Test
    void testPatchDtoToAccountHolder() {
        // given
        AccountHolderPatchDtoIn accountDto = new AccountHolderPatchDtoIn(ID, EMAIL, PASSWORD, Role.USER);

        // when
        AccountHolder dtoOut = mapper.dtoToAccountHolder(accountDto);

        // then
        assertNotNull(dtoOut);
        assertEquals(ID, dtoOut.getId());
        assertEquals(EMAIL, dtoOut.getEmail());
        assertEquals(PASSWORD, dtoOut.getPassword());
        assertEquals(Role.USER, dtoOut.getRole());
    }
}