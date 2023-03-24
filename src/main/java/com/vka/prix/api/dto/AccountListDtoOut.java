package com.vka.prix.api.dto;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountListDtoOut extends BaseDtoOut {

  private List<AccountGetDtoOut> accountList;

}
