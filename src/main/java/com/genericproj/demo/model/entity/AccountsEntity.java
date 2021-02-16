package com.genericproj.demo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;



@Entity
@Getter
@Setter
@Table(name = "accounts")
public class AccountsEntity extends BaseEntity {
    @Basic
    @Column(name = "owner", nullable = false)
    private String owner;
    @Basic
    @Column(name = "balance", nullable = false)
    private long balance;
    @Basic
    @Column(name = "currency", nullable = false)
    private String currency;


}
