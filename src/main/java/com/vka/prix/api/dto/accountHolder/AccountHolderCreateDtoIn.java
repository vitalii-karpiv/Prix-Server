package com.vka.prix.api.dto.accountHolder;

import com.vka.prix.api.dto.BaseDtoOut;
import com.vka.prix.domain.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderCreateDtoIn {

  private String email;
  private String password;
  private Role role;

}
