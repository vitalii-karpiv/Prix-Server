package com.vka.prix.unit.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vka.prix.api.dto.account.AccountCreateDtoOut;
import com.vka.prix.api.dto.account.AccountPatchDtoIn;
import com.vka.prix.api.dto.account.AccountPatchDtoOut;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = AccountController.class)
class PatchAccountTest {

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
    void testPatchAccount() throws Exception {
        // given
        Long accountId = 1L;
        AccountPatchDtoIn dtoIn = new AccountPatchDtoIn(accountId, 1000.0, "red", "UAH", null, null);
        AccountPatchDtoOut dtoOut = new AccountPatchDtoOut();
        dtoOut.setId(accountId);
        dtoOut.setBalance(1000.0);
        dtoOut.setColor("red");
        dtoOut.setCurrency("UAH");
        dtoOut.setName("Checking");
        dtoOut.setType("Asset");

        // when
        when(accountService.patchAccount(any(AccountPatchDtoIn.class))).thenReturn(dtoOut);

        // then
        MvcResult mvcResult = mockMvc.perform(patch("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoIn))
                        .characterEncoding(StandardCharsets.UTF_8.toString()))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        AccountPatchDtoOut responseDto = objectMapper.readValue(responseJson, AccountPatchDtoOut.class);

        assertEquals(accountId, responseDto.getId());
        assertEquals(1000.0, responseDto.getBalance());
        assertEquals("red", responseDto.getColor());
        assertEquals("UAH", responseDto.getCurrency());
        assertEquals("Checking", responseDto.getName());
        assertEquals("Asset", responseDto.getType());
    }
}
