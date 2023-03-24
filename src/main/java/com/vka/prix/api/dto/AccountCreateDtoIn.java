package com.vka.prix.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDtoIn {

  private Double balance;
  private String color;
  private String currency;
  private String name;
  private String type;

}
