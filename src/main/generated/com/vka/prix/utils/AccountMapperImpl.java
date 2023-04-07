package com.vka.prix.utils;

import com.vka.prix.api.dto.account.AccountCreateDtoIn;
import com.vka.prix.api.dto.account.AccountCreateDtoOut;
import com.vka.prix.api.dto.account.AccountGetDtoOut;
import com.vka.prix.api.dto.account.AccountPatchDtoIn;
import com.vka.prix.api.dto.account.AccountPatchDtoOut;
import com.vka.prix.api.dto.account.AccountPutDtoIn;
import com.vka.prix.api.dto.account.AccountPutDtoOut;
import com.vka.prix.domain.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T17:47:15+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountGetDtoOut accountToGetDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountGetDtoOut accountGetDtoOut = new AccountGetDtoOut();

        accountGetDtoOut.setId( account.getId() );
        accountGetDtoOut.setBalance( account.getBalance() );
        accountGetDtoOut.setColor( account.getColor() );
        accountGetDtoOut.setCurrency( account.getCurrency() );
        accountGetDtoOut.setName( account.getName() );
        accountGetDtoOut.setType( account.getType() );

        return accountGetDtoOut;
    }

    @Override
    public AccountCreateDtoOut accountToCreateDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountCreateDtoOut accountCreateDtoOut = new AccountCreateDtoOut();

        accountCreateDtoOut.setId( account.getId() );
        accountCreateDtoOut.setBalance( account.getBalance() );
        accountCreateDtoOut.setColor( account.getColor() );
        accountCreateDtoOut.setCurrency( account.getCurrency() );
        accountCreateDtoOut.setName( account.getName() );
        accountCreateDtoOut.setType( account.getType() );

        return accountCreateDtoOut;
    }

    @Override
    public AccountPutDtoOut accountToPutDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountPutDtoOut accountPutDtoOut = new AccountPutDtoOut();

        accountPutDtoOut.setId( account.getId() );
        accountPutDtoOut.setBalance( account.getBalance() );
        accountPutDtoOut.setColor( account.getColor() );
        accountPutDtoOut.setCurrency( account.getCurrency() );
        accountPutDtoOut.setName( account.getName() );
        accountPutDtoOut.setType( account.getType() );

        return accountPutDtoOut;
    }

    @Override
    public AccountPatchDtoOut accountToPatchDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountPatchDtoOut accountPatchDtoOut = new AccountPatchDtoOut();

        accountPatchDtoOut.setId( account.getId() );
        accountPatchDtoOut.setBalance( account.getBalance() );
        accountPatchDtoOut.setColor( account.getColor() );
        accountPatchDtoOut.setCurrency( account.getCurrency() );
        accountPatchDtoOut.setName( account.getName() );
        accountPatchDtoOut.setType( account.getType() );

        return accountPatchDtoOut;
    }

    @Override
    public List<AccountGetDtoOut> accountToListDto(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountGetDtoOut> list = new ArrayList<AccountGetDtoOut>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( accountToGetDto( account ) );
        }

        return list;
    }

    @Override
    public Account dtoToAccount(AccountCreateDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        Account account = new Account();

        account.setBalance( dtoIn.getBalance() );
        account.setColor( dtoIn.getColor() );
        account.setCurrency( dtoIn.getCurrency() );
        account.setName( dtoIn.getName() );
        account.setType( dtoIn.getType() );

        return account;
    }

    @Override
    public Account dtoToAccount(AccountPutDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( dtoIn.getId() );
        account.setBalance( dtoIn.getBalance() );
        account.setColor( dtoIn.getColor() );
        account.setCurrency( dtoIn.getCurrency() );
        account.setName( dtoIn.getName() );
        account.setType( dtoIn.getType() );

        return account;
    }

    @Override
    public Account dtoToAccount(AccountPatchDtoIn dtoIn) {
        if ( dtoIn == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( dtoIn.getId() );
        account.setBalance( dtoIn.getBalance() );
        account.setColor( dtoIn.getColor() );
        account.setCurrency( dtoIn.getCurrency() );
        account.setName( dtoIn.getName() );
        account.setType( dtoIn.getType() );

        return account;
    }
}
