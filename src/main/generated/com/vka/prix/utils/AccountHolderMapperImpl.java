package com.vka.prix.utils;

import com.vka.prix.api.dto.accountHolder.AccountHolderGetDtoOut;
import com.vka.prix.api.dto.accountHolder.AccountHolderPatchDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderPatchDtoOut;
import com.vka.prix.api.dto.accountHolder.AccountHolderPutDtoIn;
import com.vka.prix.api.dto.accountHolder.AccountHolderPutDtoOut;
import com.vka.prix.domain.AccountHolder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T17:35:33+0300",
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
    public AccountHolderPatchDtoOut accountToPatchDto(AccountHolder account) {
        if ( account == null ) {
            return null;
        }

        AccountHolderPatchDtoOut accountHolderPatchDtoOut = new AccountHolderPatchDtoOut();

        accountHolderPatchDtoOut.setId( account.getId() );
        accountHolderPatchDtoOut.setEmail( account.getEmail() );
        accountHolderPatchDtoOut.setPassword( account.getPassword() );
        accountHolderPatchDtoOut.setRole( account.getRole() );

        return accountHolderPatchDtoOut;
    }

    @Override
    public AccountHolderPutDtoOut accountToPutDto(AccountHolder account) {
        if ( account == null ) {
            return null;
        }

        AccountHolderPutDtoOut accountHolderPutDtoOut = new AccountHolderPutDtoOut();

        accountHolderPutDtoOut.setId( account.getId() );
        accountHolderPutDtoOut.setEmail( account.getEmail() );
        accountHolderPutDtoOut.setPassword( account.getPassword() );
        accountHolderPutDtoOut.setRole( account.getRole() );

        return accountHolderPutDtoOut;
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
    public AccountHolder dtoToAccountHolder(AccountHolderPatchDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        AccountHolder.AccountHolderBuilder accountHolder = AccountHolder.builder();

        accountHolder.id( dtoIn.getId() );
        accountHolder.email( dtoIn.getEmail() );
        accountHolder.password( dtoIn.getPassword() );
        accountHolder.role( dtoIn.getRole() );

        return accountHolder.build();
    }

    @Override
    public AccountHolder dtoToAccountHolder(AccountHolderPutDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        AccountHolder.AccountHolderBuilder accountHolder = AccountHolder.builder();

        accountHolder.id( dtoIn.getId() );
        accountHolder.email( dtoIn.getEmail() );
        accountHolder.password( dtoIn.getPassword() );
        accountHolder.role( dtoIn.getRole() );

        return accountHolder.build();
    }
}
