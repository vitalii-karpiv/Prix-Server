package com.vka.prix.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vka.prix.api.dto.AccountCreateDtoIn;
import com.vka.prix.api.dto.AccountCreateDtoOut;
import com.vka.prix.controller.AccountController;
import com.vka.prix.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AccountController.class)
class CreateAccountTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private AccountService accountService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCreateAccount() throws Exception {
    // given
    Long accountId = 1L;
    AccountCreateDtoIn dtoIn = new AccountCreateDtoIn(1000.0, "blue", "USD", "Checking", "Asset");
    AccountCreateDtoOut dtoOut = new AccountCreateDtoOut();
    dtoOut.setId(accountId);
    dtoOut.setBalance(1000.0);
    dtoOut.setColor("blue");
    dtoOut.setCurrency("USD");
    dtoOut.setName("Checking");
    dtoOut.setType("Asset");

    // when
    when(accountService.createAccount(any(AccountCreateDtoIn.class))).thenReturn(dtoOut);

    // then
    MvcResult mvcResult = mockMvc.perform(post("/api/v1/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(dtoIn))
                    .characterEncoding(StandardCharsets.UTF_8.toString()))
            .andExpect(status().isCreated())
            .andReturn();

    String responseJson = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
    AccountCreateDtoOut responseDto = objectMapper.readValue(responseJson, AccountCreateDtoOut.class);

    assertEquals(accountId, responseDto.getId());
    assertEquals(1000.0, responseDto.getBalance());
    assertEquals("blue", responseDto.getColor());
    assertEquals("USD", responseDto.getCurrency());
    assertEquals("Checking", responseDto.getName());
    assertEquals("Asset", responseDto.getType());
  }
}

