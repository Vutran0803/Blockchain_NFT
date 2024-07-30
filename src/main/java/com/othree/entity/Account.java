package com.othree.entity;



import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


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

