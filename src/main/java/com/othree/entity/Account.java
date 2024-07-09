package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
