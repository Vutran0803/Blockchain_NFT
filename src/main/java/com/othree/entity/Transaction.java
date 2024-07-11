package com.othree.entyti;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import java.util.Date;

@Entity
@Table(name = "[Transaction]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "buyerId", nullable = false)
    private Account buyer;

    @ManyToOne
    @JoinColumn(name = "sellerId", nullable = false)
    private Account seller;

    @ManyToOne
    @JoinColumn(name = "nftId", nullable = false)
    private NFT nft;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private double amount;
}
