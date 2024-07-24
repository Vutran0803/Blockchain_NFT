package com.othree.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false, unique = true)
    private String rolename;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Authorities> authorities;

    // Getters and Setters
}
