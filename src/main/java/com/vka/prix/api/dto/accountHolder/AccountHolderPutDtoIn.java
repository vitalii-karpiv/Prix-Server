package com.vka.prix.api.dto.accountHolder;

import com.vka.prix.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderPutDtoIn {

  private Long id;
  private String email;
  private String password;
  private Role role;

}
