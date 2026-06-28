package com.adour.openclassprog.model;

import jakarta.persistence.*;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/06/2026 - 9:46
 */
@Entity
@Table(name = "KODE_WILAYAH")
public class Wilayah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "kode_wilayah")
    public String kodeWilayah;
    @Column(name = "nama_wilayah")
    public String namaWilayah;
}
