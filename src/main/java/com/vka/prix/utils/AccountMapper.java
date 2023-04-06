package com.vka.prix.utils;

import com.vka.prix.api.dto.account.*;
import com.vka.prix.domain.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

  // From account to DTO
  @Mapping(target = "errorMap", ignore = true)
  AccountGetDtoOut accountToGetDto(Account account);
  @Mapping(target = "errorMap", ignore = true)
  AccountCreateDtoOut accountToCreateDto(Account account);
  @Mapping(target = "errorMap", ignore = true)
  AccountPutDtoOut accountToPutDto(Account account);
  @Mapping(target = "errorMap", ignore = true)
  AccountPatchDtoOut accountToPatchDto(Account account);
  List<AccountGetDtoOut> accountToListDto(List<Account> accountList);

  // From DTO to account
  @Mapping(target = "id", ignore = true)
  Account dtoToAccount(AccountCreateDtoIn dtoIn);
  Account dtoToAccount(AccountPutDtoIn dtoIn);
  Account dtoToAccount(AccountPatchDtoIn dtoIn);


}
