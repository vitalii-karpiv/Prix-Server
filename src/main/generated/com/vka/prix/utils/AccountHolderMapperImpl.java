package com.vka.prix.utils;

import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderCreateDtoOut;
import com.vka.prix.api.dto.accountHolder.AccountHolderGetDtoOut;
import com.vka.prix.api.dto.accountHolder.AccountHolderUpdateDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderUpdateDtoOut;
import com.vka.prix.domain.AccountHolder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:53:14+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class AccountHolderMapperImpl implements AccountHolderMapper {

    @Override
    public AccountHolderGetDtoOut accountToGetDto(AccountHolder account) {
        if ( account == null ) {
            return null;
        }

        AccountHolderGetDtoOut accountHolderGetDtoOut = new AccountHolderGetDtoOut();

        accountHolderGetDtoOut.setId( account.getId() );
        accountHolderGetDtoOut.setEmail( account.getEmail() );
        accountHolderGetDtoOut.setPassword( account.getPassword() );
        accountHolderGetDtoOut.setRole( account.getRole() );

        return accountHolderGetDtoOut;
    }

    @Override
    public AccountHolderCreateDtoOut accountToCreateDto(AccountHolder account) {
        if ( account == null ) {
            return null;
        }

        AccountHolderCreateDtoOut accountHolderCreateDtoOut = new AccountHolderCreateDtoOut();

        return accountHolderCreateDtoOut;
    }

    @Override
    public AccountHolderUpdateDtoOut accountToUpdateDto(AccountHolder account) {
        if ( account == null ) {
            return null;
        }

        AccountHolderUpdateDtoOut accountHolderUpdateDtoOut = new AccountHolderUpdateDtoOut();

        accountHolderUpdateDtoOut.setId( account.getId() );
        accountHolderUpdateDtoOut.setEmail( account.getEmail() );
        accountHolderUpdateDtoOut.setPassword( account.getPassword() );
        accountHolderUpdateDtoOut.setRole( account.getRole() );

        return accountHolderUpdateDtoOut;
    }

    @Override
    public List<AccountHolderGetDtoOut> accountToListDto(List<AccountHolder> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountHolderGetDtoOut> list = new ArrayList<AccountHolderGetDtoOut>( accountList.size() );
        for ( AccountHolder accountHolder : accountList ) {
            list.add( accountToGetDto( accountHolder ) );
        }

        return list;
    }

    @Override
    public AccountHolder dtoToAccount(AccountHolderCreateDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        AccountHolder accountHolder = new AccountHolder();

        accountHolder.setEmail( dtoIn.getEmail() );
        accountHolder.setPassword( dtoIn.getPassword() );
        accountHolder.setRole( dtoIn.getRole() );

        return accountHolder;
    }

    @Override
    public AccountHolder dtoToAccount(AccountHolderUpdateDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        AccountHolder accountHolder = new AccountHolder();

        accountHolder.setId( dtoIn.getId() );
        accountHolder.setEmail( dtoIn.getEmail() );
        accountHolder.setPassword( dtoIn.getPassword() );
        accountHolder.setRole( dtoIn.getRole() );

        return accountHolder;
    }
}
