package com.genericproj.demo.api;


import com.genericproj.demo.model.entity.AccountsEntity;
import com.genericproj.demo.service.impl.AbstractGenericBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@RestController
public class testCon {
    @Qualifier("accountsImpl")
    @Autowired
    AbstractGenericBaseService<AccountsEntity,Long> accountService;

    @GetMapping("/cAccounts")
    public Callable<List<AccountsEntity>> getAccountsApi() {
        return () -> accountService.findAll().orElseThrow(IllegalStateException::new);
    }

    @GetMapping("/Accounts")
    public Optional<List<AccountsEntity>> getAccountsApi2() {
        return accountService.findAll();
    }


    @PostMapping("/Accounts")
    public HttpStatus postAccount(@RequestBody AccountsEntity account){
        accountService.save(account);
        return HttpStatus.CREATED;

    }
    @PostMapping("/cAccounts")
    public Callable<HttpStatus> postAccount2(@RequestBody AccountsEntity account){
        accountService.save(account);
        return ()->HttpStatus.CREATED;

    }
}
