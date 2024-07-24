package com.othree.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionsId;

    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionsDate = new Date();

    private String transactionsdetails;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private Account account;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Set<TransactionsDetail> transactionsDetails;

    // Getters and Setters
}
