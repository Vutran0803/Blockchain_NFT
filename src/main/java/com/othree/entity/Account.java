package com.othree.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Authorities> authorities;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<ImageNFT> imageNFTs;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    // Getters and Setters
}

