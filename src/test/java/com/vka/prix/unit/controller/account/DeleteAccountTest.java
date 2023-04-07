package com.vka.prix.unit.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vka.prix.api.dto.account.AccountDeleteDtoIn;
import com.vka.prix.api.dto.account.AccountDeleteDtoOut;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = AccountController.class)
class DeleteAccountTest {

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
    void testDeleteAccount() throws Exception {
        // given
        Long accountId = 1L;
        AccountDeleteDtoIn dtoIn = new AccountDeleteDtoIn(accountId);
        AccountDeleteDtoOut dtoOut = new AccountDeleteDtoOut();

        // when
        when(accountService.deleteAccount(any(AccountDeleteDtoIn.class))).thenReturn(dtoOut);

        // then
        MvcResult mvcResult = mockMvc.perform(delete("/api/v1/accounts/" + accountId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoIn))
                        .characterEncoding(StandardCharsets.UTF_8.toString()))
                .andExpect(status().isNoContent())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        AccountDeleteDtoOut responseDto = objectMapper.readValue(responseJson, AccountDeleteDtoOut.class);

        assertNotNull(responseDto.getErrorMap());
    }
}
