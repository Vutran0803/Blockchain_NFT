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
@Table(name = "NFT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NFT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nftId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String imageURL;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private Account owner;

    @OneToMany(mappedBy = "nft")
    private List<Review> reviews;
}
