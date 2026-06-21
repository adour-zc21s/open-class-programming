package com.adour.openclassprog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:08
 */

@Data
@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor
@AllArgsConstructor
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
    private double balance;
    @Column
    private String hp;
    @Column
    private String email;
    @Column
    private String address;

}
