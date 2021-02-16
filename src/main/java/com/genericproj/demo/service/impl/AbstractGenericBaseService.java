package com.genericproj.demo.service.impl;

import com.genericproj.demo.model.entity.BaseEntity;
import com.genericproj.demo.service.GenericBaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public abstract class AbstractGenericBaseService<T extends BaseEntity, ID> implements GenericBaseService<T, ID> {

    private JpaRepository<T, ID> genericBaseRepository;
    public AbstractGenericBaseService(JpaRepository<T, ID> genericBaseRepository) {
        this.genericBaseRepository = genericBaseRepository;
    }

    @Override
    public T save(T entity) {
        return (T) genericBaseRepository.save(entity);
    }

    @Override
    public Optional<List<T>> findAll() {
        //add businesslogic?
        return Optional.of(genericBaseRepository.findAll());
    }

    @Override
    public Optional<T> findById(ID entityId) {

        return genericBaseRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        //business logic...
        return null;
    }

    @Override
    public T updateById(T entity, ID entityId) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteById(ID entityId) {

    }

    @Override
    public T someBusinessLogicMethod(T entity) {
        return null;
    }

    public abstract String OtherLogic();
}
