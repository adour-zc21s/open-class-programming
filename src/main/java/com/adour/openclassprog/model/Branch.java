package com.adour.openclassprog.model;

import jakarta.persistence.*;
import lombok.*;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 24/06/2026 - 17:24
 */
@Entity
@Table(name = "BRANCHES")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "nama_pt", nullable = true)
    private String namaPt;
    @Column(name = "nama_isp1")
    private String namaIsp1;
    @Column(name = "no_isp1")
    private String noIsp1;
    @Column(name = "nama_isp2")
    private String namaIsp2;
    @Column(name = "no_isp2")
    private String noIsp2;
    @Column(name = "is_active")
    private String isActive;
    @Column(name = "email_digunakan")
    private String emailDigunakan;
    @Column(name = "branch_name")
    private String branchName;
    private String npwp;
    private String address;
    private String description;

    // Setter and Getter
    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getAddress() { return address; }

    public String getNamaPt() {
        return namaPt;
    }

    public void setNamaPt(String namaPt) {
        this.namaPt = namaPt;
    }

    public String getNamaIsp1() {
        return namaIsp1;
    }

    public void setNamaIsp1(String namaIsp1) {
        this.namaIsp1 = namaIsp1;
    }

    public String getNoIsp1() {
        return noIsp1;
    }

    public void setNoIsp1(String noIsp1) {
        this.noIsp1 = noIsp1;
    }

    public String getNamaIsp2() {
        return namaIsp2;
    }

    public void setNamaIsp2(String namaIsp2) {
        this.namaIsp2 = namaIsp2;
    }

    public String getNoIsp2() {
        return noIsp2;
    }

    public void setNoIsp2(String noIsp2) {
        this.noIsp2 = noIsp2;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getEmailDigunakan() {
        return emailDigunakan;
    }

    public void setEmailDigunakan(String emailDigunakan) {
        this.emailDigunakan = emailDigunakan;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
