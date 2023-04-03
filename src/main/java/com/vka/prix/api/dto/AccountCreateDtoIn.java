package com.vka.prix.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDtoIn extends BaseDtoOut {

  private Double balance;
  private String color;
  private String currency;
  private String name;
  private String type;

}
