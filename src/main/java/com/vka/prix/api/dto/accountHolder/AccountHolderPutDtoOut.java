package com.vka.prix.api.dto.accountHolder;

import com.vka.prix.api.dto.BaseDtoOut;
import com.vka.prix.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderPutDtoOut extends BaseDtoOut {

  private Long id;
  private String email;
  private String password;
  private Role role;

}
