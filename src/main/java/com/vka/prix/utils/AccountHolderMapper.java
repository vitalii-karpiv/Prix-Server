package com.vka.prix.utils;

import com.vka.prix.api.dto.accountHolder.*;
import com.vka.prix.domain.AccountHolder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountHolderMapper {

  AccountHolderMapper INSTANCE = Mappers.getMapper(AccountHolderMapper.class);

  // From account to DTO
  @Mapping(target = "errorMap", ignore = true)
  AccountHolderGetDtoOut accountToGetDto(AccountHolder account);

  @Mapping(target = "errorMap", ignore = true)
  AccountHolderCreateDtoOut accountToCreateDto(AccountHolder account);

  @Mapping(target = "errorMap", ignore = true)
  AccountHolderUpdateDtoOut accountToUpdateDto(AccountHolder account);

  List<AccountHolderGetDtoOut> accountToListDto(List<AccountHolder> accountList);

  // From DTO to account
  @Mapping(target = "id", ignore = true)
  AccountHolder dtoToAccount(AccountHolderCreateDtoIn dtoIn);

  AccountHolder dtoToAccount(AccountHolderUpdateDtoIn dtoIn);


}
