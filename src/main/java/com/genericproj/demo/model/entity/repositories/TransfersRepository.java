package com.genericproj.demo.model.entity.repositories;

import com.genericproj.demo.model.entity.TransfersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfersRepository extends JpaRepository<TransfersEntity,Long> {
}
