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
@Table(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @OneToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String phoneNumber;
}
