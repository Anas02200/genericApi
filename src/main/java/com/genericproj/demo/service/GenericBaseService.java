package com.genericproj.demo.service;

import com.genericproj.demo.api.rest.GenericResourceController;
import com.genericproj.demo.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericBaseService<T extends BaseEntity, ID> {
    T save(T entity);

    Optional<List<T>> findAll();

    Optional<T> findById(ID entityId);

    T update(T entity);

    T updateById(T entity, ID entityId);

    void delete(T entity);

    void deleteById(ID entityId);

    T someBusinessLogicMethod(T entity);
}
