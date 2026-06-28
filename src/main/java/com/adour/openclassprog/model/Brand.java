package com.adour.openclassprog.model;

import jakarta.persistence.*;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 28/06/2026 - 11:02
 */
@Entity
@Table(name = "KODE_BRAND")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "kode_brand")
    public String kodeBrand;
    @Column(name = "nama_brand")
    public String namaBrand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeBrand() {
        return kodeBrand;
    }

    public void setKodeBrand(String kodeBrand) {
        this.kodeBrand = kodeBrand;
    }

    public String getNamaBrand() {
        return namaBrand;
    }

    public void setNamaBrand(String namaBrand) {
        this.namaBrand = namaBrand;
    }
}
