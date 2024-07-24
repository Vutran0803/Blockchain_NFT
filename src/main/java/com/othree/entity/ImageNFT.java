package com.othree.entity;

import java.math.BigDecimal;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "ImageNFT")
public class ImageNFT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nftId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @Lob
    private String image; // Use @Lob for binary data

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private Account account;

    // Getters and Setters
}

