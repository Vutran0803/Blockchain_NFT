package com.othree.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private Integer accountId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "accountId")
    private Account account;

    private String fullname;
    private String email;
    private String photo;
    private String phone;
    private String walletkey;

    // Getters and Setters
}
