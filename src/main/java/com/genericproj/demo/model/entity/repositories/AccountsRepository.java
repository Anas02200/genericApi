package com.genericproj.demo.model.entity.repositories;

import com.genericproj.demo.model.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity,Long> {
}
