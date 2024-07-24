package com.othree.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Authorities")
public class Authorities {
    @EmbeddedId
    private AuthorityKey id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    private Role role;

    // Getters and Setters
}

@Embeddable
class AuthorityKey implements Serializable {
    private Integer accountId;
    private Integer roleId;

    // Getters and Setters, hashCode, equals
}
