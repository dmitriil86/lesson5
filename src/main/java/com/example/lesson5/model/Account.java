package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_pool_id")
    private AccountPool accountPoolId;

    @Column(name = "account_number", length = 25)
    private String accountNumber;

    @Column(name = "bussy")
    private Boolean bussy;
}
