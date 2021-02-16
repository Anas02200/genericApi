package com.genericproj.demo.service.impl;

import com.genericproj.demo.model.entity.AccountsEntity;
import com.genericproj.demo.model.entity.repositories.AccountsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountsImpl extends AbstractGenericBaseService<AccountsEntity, Long> {
    public AccountsImpl(AccountsRepository genericBaseRepository) {
        super(genericBaseRepository);
    }

    @Override
    public String OtherLogic() {
        return this.getClass().getName();
    }
}
