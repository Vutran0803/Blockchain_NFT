package com.othree.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "nftId")
    private ImageNFT imageNFT;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate = new Date();

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Account account;

    // Getters and Setters
}
