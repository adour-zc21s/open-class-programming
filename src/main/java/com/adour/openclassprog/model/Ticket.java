package com.adour.openclassprog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 16:29
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_tiket", unique = true, nullable = false)
    private String noTiket;

    @Column(name = "email")
    private String email;

    @Column(name = "departemen")
    private String departemen;

    @Column(name = "priority")
    private String priority;

    @Column(name = "judul")
    private String judul;

    @Column(name = "dibuat_oleh")
    private String dibuatOleh;

    @Column(name = "email_notification")
    private String emailNotification;

    @Column(name = "branch")
    private String branch;

    @Column(name = "jenis_dukungan")
    private String jenisDukungan;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "closing_message", columnDefinition = "TEXT")
    private String closingMessage;

    private String status = "Open";

    private Integer rating;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @Column(name = "ditutup_oleh")
    private String ditutupOleh;

    @Column(name = "komentar", columnDefinition = "TEXT")
    private String komentar;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "tgl_komentar")
    private LocalDateTime tglKomentar;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketComment> comments = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = "Open";
        }
    }
}
