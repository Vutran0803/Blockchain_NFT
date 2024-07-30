package com.othree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Authorities")
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authoritieID;
    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    // Constructors, Getters, and Setters
}
