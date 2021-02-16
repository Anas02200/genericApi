package com.genericproj.demo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "entries")
public class EntriesEntity extends BaseEntity {
    @Basic
    @Column(name = "amount", nullable = false)
    private long amount;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private AccountsEntity accountsByAccountId;
}
