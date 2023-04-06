package com.vka.prix.api.dto.account;

import com.vka.prix.api.dto.BaseDtoOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDtoOut extends BaseDtoOut {

  private Long id;
  private Double balance;
  private String color;
  private String currency;
  private String name;
  private String type;

}
