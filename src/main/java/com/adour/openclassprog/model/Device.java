package com.adour.openclassprog.model;

import com.adour.openclassprog.enums.DeviceType;
import jakarta.persistence.*;

import java.util.Date;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 25/06/2026 - 10:03
 */
@Entity
@Table(name = "DEVICES")
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
    private String description;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getWarrantyExpired() {
        return warrantyExpired;
    }

    public void setWarrantyExpired(Date warrantyExpired) {
        this.warrantyExpired = warrantyExpired;
    }
}
