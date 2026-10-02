package com.adour.openclassprog.pocket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:19
 */
@Entity
@Table(name = "pockets")
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Contoh: "Pocket Utama", "Pocket Tabungan"

    private String description;

    @OneToMany(mappedBy = "pocket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PocketItem> items = new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructor
    public Pocket() {}

    public Pocket(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Helper Method untuk menghitung total saldo
    public BigDecimal getTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (PocketItem item : items) {
            if (item.getType() == TransactionType.SALARY || item.getType() == TransactionType.OTHERS_INCOME) {
                total = total.add(item.getAmount());
            } else if (item.getType() == TransactionType.EXPENSE) {
                total = total.subtract(item.getAmount());
            }
        }
        return total;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<PocketItem> getItems() { return items; }
    public void setItems(List<PocketItem> items) { this.items = items; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    // Helper method untuk menambah item
    public void addItem(PocketItem item) {
        items.add(item);
        item.setPocket(this);
    }
}
