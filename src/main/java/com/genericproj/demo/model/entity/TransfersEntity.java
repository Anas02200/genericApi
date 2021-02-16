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
@Table(name = "transfers")
public class TransfersEntity extends BaseEntity {

    @Basic
    @Column(name = "amount", nullable = false)
    private long amount;

    @ManyToOne
    @JoinColumn(name = "from_account_id", referencedColumnName = "id", nullable = false)
    private AccountsEntity accountsByFromAccountId;

    @ManyToOne
    @JoinColumn(name = "to_account_id", referencedColumnName = "id", nullable = false)
    private AccountsEntity accountsByToAccountId;

}
