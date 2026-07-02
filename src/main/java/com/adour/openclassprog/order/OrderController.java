package com.adour.openclassprog.order;

import com.adour.openclassprog.model.Item;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 20:05
 */
@RestController
@RequestMapping("/api/v1/order")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Add an item to the catalog
    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return orderService.createItem(item);
    }

    // View catalog
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return orderService.getAllItems();
    }

    // Checkout / Place an order
    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // View all order histories
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
