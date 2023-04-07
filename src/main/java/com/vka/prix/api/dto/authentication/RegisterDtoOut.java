package com.vka.prix.api.dto.authentication;

import com.vka.prix.api.dto.BaseDtoOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDtoOut extends BaseDtoOut {

  private String token;

}
