package com.vka.prix.unit.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vka.prix.api.dto.account.AccountGetDtoIn;
import com.vka.prix.api.dto.account.AccountGetDtoOut;
import com.vka.prix.api.dto.account.AccountListDtoIn;
import com.vka.prix.api.dto.account.AccountListDtoOut;
import com.vka.prix.controller.AccountController;
import com.vka.prix.domain.Account;
import com.vka.prix.service.AccountHolderService;
import com.vka.prix.service.AccountService;
import com.vka.prix.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = AccountController.class)
class ListAccountTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AccountService accountService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private AccountHolderService accountHolderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAccount() throws Exception {
        // given
        Long accountId = 1L;
        AccountListDtoOut dtoOut = new AccountListDtoOut();
        AccountGetDtoOut account = new AccountGetDtoOut();
        account.setId(accountId);
        account.setBalance(1000.0);
        account.setColor("blue");
        account.setCurrency("USD");
        account.setName("Checking");
        account.setType("Asset");
        List<AccountGetDtoOut> accountList = new ArrayList<>();
        accountList.add(account);
        dtoOut.setAccountList(accountList);

        // when
        when(accountService.listAccounts(any(AccountListDtoIn.class))).thenReturn(dtoOut);

        // then
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8.toString()))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        AccountListDtoOut responseDto = objectMapper.readValue(responseJson, AccountListDtoOut.class);

        assertEquals(1, responseDto.getAccountList().size());
        AccountGetDtoOut acc = responseDto.getAccountList().get(0);
        assertEquals(accountId, acc.getId());
        assertEquals(1000.0, acc.getBalance());
        assertEquals("blue", acc.getColor());
        assertEquals("USD", acc.getCurrency());
        assertEquals("Checking", acc.getName());
        assertEquals("Asset", acc.getType());
    }
}
