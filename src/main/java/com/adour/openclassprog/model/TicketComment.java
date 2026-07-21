package com.adour.openclassprog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 09/07/2026 - 17:14
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets_comments")
@EntityListeners(AuditingEntityListener.class)
public class TicketComment {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "ticket_id", nullable = false)
 private Ticket ticket;

 @Column(name = "comment", columnDefinition = "TEXT")
 private String comment;

 @CreatedDate
 @Column(name = "created_at", nullable = false, updatable = false)
 private LocalDateTime createdAt;

 @LastModifiedDate
 @Column(name = "updated_at")
 private LocalDateTime updatedAt;
}
