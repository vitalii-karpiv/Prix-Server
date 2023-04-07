package com.vka.prix.unit.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vka.prix.api.dto.account.AccountPutDtoIn;
import com.vka.prix.api.dto.account.AccountPutDtoOut;
import com.vka.prix.controller.AccountController;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = AccountController.class)
class PutAccountTest {

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
    void testPutAccount() throws Exception {
        // given
        Long accountId = 1L;
        AccountPutDtoIn dtoIn = new AccountPutDtoIn(accountId, 1000.0, "red", "UAH", null, null);
        AccountPutDtoOut dtoOut = new AccountPutDtoOut();
        dtoOut.setId(accountId);
        dtoOut.setBalance(1000.0);
        dtoOut.setColor("red");
        dtoOut.setCurrency("UAH");
        dtoOut.setName(null);
        dtoOut.setType(null);

        // when
        when(accountService.putAccount(any(AccountPutDtoIn.class))).thenReturn(dtoOut);

        // then
        MvcResult mvcResult = mockMvc.perform(put("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoIn))
                        .characterEncoding(StandardCharsets.UTF_8.toString()))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        AccountPutDtoOut responseDto = objectMapper.readValue(responseJson, AccountPutDtoOut.class);

        assertEquals(accountId, responseDto.getId());
        assertEquals(1000.0, responseDto.getBalance());
        assertEquals("red", responseDto.getColor());
        assertEquals("UAH", responseDto.getCurrency());
        assertNull(null, responseDto.getName());
        assertNull(null, responseDto.getType());
    }
}
