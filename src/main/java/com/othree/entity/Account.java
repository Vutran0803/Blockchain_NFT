package com.othree.entyti;


import javax.persistence.*;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "account")
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "account")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "owner")
    private List<NFT> nfts;

    @OneToMany(mappedBy = "buyer")
    private List<Transaction> transactionsAsBuyer;

    @OneToMany(mappedBy = "seller")
    private List<Transaction> transactionsAsSeller;

    @OneToMany(mappedBy = "account")
    private List<Review> reviews;

    @OneToOne(mappedBy = "account")
    private Customer customer;
}
