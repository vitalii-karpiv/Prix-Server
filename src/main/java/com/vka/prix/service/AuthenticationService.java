package com.vka.prix.service;

import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoOut;
import com.vka.prix.api.dto.authentication.AuthenticateDtoIn;
import com.vka.prix.api.dto.authentication.AuthenticateDtoOut;
import com.vka.prix.domain.AccountHolder;
import com.vka.prix.domain.Role;
import com.vka.prix.repository.AccountHolderRepository;
import com.vka.prix.utils.AccountHolderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final AccountHolderRepository accountHolderRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;

  private static final AccountHolderMapper accountHolderMapper = AccountHolderMapper.INSTANCE;

  public AccountHolderCreateDtoOut register(AccountHolderCreateDtoIn dtoIn) {
    AccountHolder ah = AccountHolder.builder()
            .email(dtoIn.getEmail())
            .password(passwordEncoder.encode(dtoIn.getPassword()))
            .role(Role.USER)
            .build();
    AccountHolder accountHolder = accountHolderRepository.save(ah);
    String token = jwtService.generateToken(accountHolder);
    return new AccountHolderCreateDtoOut(token);
  }

  public AuthenticateDtoOut authenticate(AuthenticateDtoIn dtoIn) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    dtoIn.getEmail(),
                    dtoIn.getPassword()
            )
    );
    AccountHolder user = accountHolderRepository.findByEmail(dtoIn.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return new AuthenticateDtoOut(jwtToken);
  }

}
