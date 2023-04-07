package com.vka.prix.api.dto.authentication;

import com.vka.prix.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDtoIn {

  private String email;
  private String password;
  private Role role;

}
