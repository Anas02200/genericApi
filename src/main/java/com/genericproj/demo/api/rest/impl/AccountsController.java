package com.genericproj.demo.api.rest.impl;
import com.genericproj.demo.model.entity.AccountsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api"+"/accounts")
public class AccountsController extends AbstractGenericResourceController<AccountsEntity,Long> {

    @Override
    public void dostuff() {

    }
}
