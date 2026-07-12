package com.adour.openclassprog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 22:00
 */
@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    // GenerationType.IDENTITY is autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nik;
    @Column
    private String accountNumber;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private Double balance;
    @Column
    private String hp;
    @Column
    private String email;
    @Column
    private String address;
}
