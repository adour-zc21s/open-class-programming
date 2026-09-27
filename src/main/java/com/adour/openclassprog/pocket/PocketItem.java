package com.adour.openclassprog.pocket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:25
 */
@Entity
@Table(name = "pocket_items")
public class PocketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // Contoh: "Gaji Bulan September", "Beli Kopi", "Bonus Proyek"

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount; // Menggunakan BigDecimal untuk akurasi nominal uang

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type; // GAJI, PEMASUKAN_LAIN, PENGELUARAN

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pocket_id", nullable = false)
    @JsonIgnoreProperties("items") // <-- Mencegah PocketItem memuat kembali daftar items milik Pocket
    @JsonIgnore
    private Pocket pocket;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @PrePersist
    protected void onCreate() {
        if (this.transactionDate == null) {
            this.transactionDate = LocalDateTime.now();
        }
    }

    // Constructor
    public PocketItem() {}

    public PocketItem(String title, BigDecimal amount, TransactionType type, Pocket pocket) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.pocket = pocket;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public Pocket getPocket() { return pocket; }
    public void setPocket(Pocket pocket) { this.pocket = pocket; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
