package com.adour.openclassprog.model;

import com.adour.openclassprog.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:03
 */
@Entity
@Table(name = "DEVICES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    // Identity and Classification
    @Column(name = "inventory_code")
    private String inventoryCode;
    // devicename or hostname
    @Column(name = "device_name")
    private String deviceName;
    private String password;
    @Column(name = "password_portal")
    private String passwordPortal;
    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;
    private String manufacture;
    @Column(name = "model_number")
    private String modelNumber;
    @Column(name = "serial_number")
    private String serialNumber;
    private String status;
    private String description;

    // Network and Connectivity
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "mac_address")
    private String macAddress;

    // Location and assignment
    private String user;
    @Column(name = "branch_name")
    private String branchName;
    private String location;
    private String department;

    // Lifecycle and asset management
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "warranty_expired")
    private Date warrantyExpired;

}
