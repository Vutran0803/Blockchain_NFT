package com.othree.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
