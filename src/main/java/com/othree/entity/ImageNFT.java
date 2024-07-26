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
    @Column(name = "NftID") // specify the exact column name
    private Integer nftId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private float price;

    @Lob
    @Column(name = "Image")
    private String image; // Use @Lob for binary data

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "Username", referencedColumnName = "Username", insertable = false, updatable = false)
    private Account account;
}
