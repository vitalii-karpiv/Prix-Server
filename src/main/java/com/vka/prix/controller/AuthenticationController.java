package com.vka.prix.controller;

import com.vka.prix.api.dto.authentication.RegisterDtoIn;
import com.vka.prix.api.dto.authentication.RegisterDtoOut;
import com.vka.prix.api.dto.authentication.AuthenticateDtoIn;
import com.vka.prix.api.dto.authentication.AuthenticateDtoOut;
import com.vka.prix.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
  @ResponseStatus(code = HttpStatus.CREATED)
  public RegisterDtoOut register(@RequestBody RegisterDtoIn request) {
    return authenticationService.register(request);
  }

}
