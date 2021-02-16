package com.genericproj.demo.api.rest;

import com.genericproj.demo.model.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public interface GenericResourceController<T extends BaseEntity, ID> {

    @GetMapping
    Callable<List<T>> getAllResources() throws Exception;

    @PostMapping
    ResponseEntity<T> createResource(@RequestBody T resource) throws ExecutionException, InterruptedException;
    // add other methods

}
