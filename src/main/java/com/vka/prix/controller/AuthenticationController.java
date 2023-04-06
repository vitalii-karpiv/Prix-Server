package com.vka.prix.controller;

import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoOut;
import com.vka.prix.api.dto.authentication.AuthenticateDtoIn;
import com.vka.prix.api.dto.authentication.AuthenticateDtoOut;
import com.vka.prix.service.AccountHolderService;
import com.vka.prix.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/authenticate")
  @ResponseStatus(code = HttpStatus.OK)
  public AuthenticateDtoOut authenticate(@RequestBody AuthenticateDtoIn request) {
    return authenticationService.authenticate(request);
  }

  @PostMapping("/register")
  @ResponseStatus(code = HttpStatus.OK)
  public AccountHolderCreateDtoOut register(@RequestBody AccountHolderCreateDtoIn request) {
    return authenticationService.register(request);
  }

}
