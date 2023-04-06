package com.vka.prix.api.dto.accountHolder;

import com.vka.prix.api.dto.BaseDtoOut;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountHolderListDtoOut extends BaseDtoOut {

  private List<AccountHolderGetDtoOut> accountList;

}
