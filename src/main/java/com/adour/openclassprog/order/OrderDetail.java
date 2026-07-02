package com.adour.openclassprog.order;

import com.adour.openclassprog.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 19:57
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private Integer quantity;
    private Double priceAtPurchase; // To keep track of history if item price changes

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore // Prevents infinite recursion during JSON serialization
    private Order order;
}
