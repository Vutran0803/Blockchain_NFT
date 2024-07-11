package com.othree.entyti;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Entity
@Table(name = "UserRole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;
}
