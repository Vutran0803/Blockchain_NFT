package com.othree.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "TransactionsDetail")
public class TransactionsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionsDetailId;

    @ManyToOne
    @JoinColumn(name = "transactionsId")
    private Transaction transaction;

    private String transactionsdetails;
    private String image;
    private float price;

    // Getters and Setters
}
