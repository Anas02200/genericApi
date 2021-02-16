package com.genericproj.demo.api.rest.impl;


import com.genericproj.demo.api.rest.GenericResourceController;
import com.genericproj.demo.model.entity.BaseEntity;
import com.genericproj.demo.service.impl.AbstractGenericBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.*;

public abstract class AbstractGenericResourceController<T extends BaseEntity, ID> implements GenericResourceController<T, ID> {

    Logger logger = LoggerFactory.getLogger(AbstractGenericResourceController.class);
    @Autowired
    AbstractGenericBaseService<T, ID> baseService;
    //ExecutorService pool = Executors.newFixedThreadPool(3);
    @Override
    public Callable<List<T>> getAllResources() throws Exception {
        Callable<String> stringCallable = () -> "ddd";
        stringCallable.call();
        logger.info("resource on");


        return () -> baseService.findAll().orElseThrow(IllegalStateException::new);
    }


    @Override
    public ResponseEntity<T> createResource(T resource) throws ExecutionException, InterruptedException {
        logger.info("creating resource");
        /*CompletableFuture result = new CompletableFuture<T>();
        pool.submit(() -> {
            logger.info(Thread.currentThread().getName()+"before sleep");
            Thread.sleep(1000);
            logger.info(Thread.currentThread().getName()+"after sleep");

            return result.complete( baseService.save(resource));
        });*/
        CompletableFuture<ResponseEntity<T>> result= CompletableFuture.supplyAsync(() -> getT(resource));
        logger.info("resource getting created");
        return result.get();
    }

    private ResponseEntity<T> getT(T resource) {
        logger.info(Thread.currentThread().getName()+"before sleep");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        baseService.save(resource);
        logger.info(Thread.currentThread().getName()+"after sleep");
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    public abstract void dostuff();
}
