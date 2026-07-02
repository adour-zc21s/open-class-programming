package com.adour.openclassprog.order;

import com.adour.openclassprog.model.Item;
import com.adour.openclassprog.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 20:02
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    // --- ITEM METHODS ---
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // --- ORDER METHODS ---
    @Transactional
    public Order createOrder(Order orderRequest) {
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setOrderDate(LocalDateTime.now());

        double totalAmount = 0.0;

        for (OrderDetail detailRequest : orderRequest.getOrderDetails()) {
            // 1. Validate Item existence
            Item item = itemRepository.findById(detailRequest.getItem().getId())
                    .orElseThrow(() -> new RuntimeException("Item not found with id: " + detailRequest.getItem().getId()));

            // 2. Check stock availability
            if (item.getStockQuantity() < detailRequest.getQuantity()) {
                throw new RuntimeException("Not enough stock for item: " + item.getName());
            }

            // 3. Deduct stock
            item.setStockQuantity(item.getStockQuantity() - detailRequest.getQuantity());
            itemRepository.save(item);

            // 4. Construct Order Detail
            OrderDetail detail = new OrderDetail();
            detail.setItem(item);
            detail.setQuantity(detailRequest.getQuantity());
            detail.setPriceAtPurchase(item.getPrice());
            detail.setOrder(order); // Map back-reference

            order.getOrderDetails().add(detail);

            // Calculate running total
            totalAmount += item.getPrice() * detailRequest.getQuantity();
        }

        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
