package com.adour.openclassprog.model;

import com.adour.openclassprog.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 8:59
 */
@Data
@Entity
@Table(name = "DEVICES")
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // Identity and Classification
    // devicename or hostname
    @Column(name = "device_name")
    private String deviceName;
    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;
    private String manufacture;
    @Column(name = "model_number")
    private String modelNumber;
    @Column(name = "serial_number")
    private String serialNumber;
    private String status;

    // Network and Connectivity
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "mac_address")
    private String macAddress;

    // Location and assignment
    private String user;
    private String location;
    private String department;

    // Lifecycle and asset management
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "warranty_expired")
    private Date warrantyExpired;




}
