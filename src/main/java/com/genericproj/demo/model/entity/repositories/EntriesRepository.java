package com.genericproj.demo.model.entity.repositories;

import com.genericproj.demo.model.entity.EntriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntriesRepository extends JpaRepository<EntriesEntity,Long> {
}
