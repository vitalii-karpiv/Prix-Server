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
public class AccountHolderCreateDtoOut extends BaseDtoOut {

  private String token;

}
