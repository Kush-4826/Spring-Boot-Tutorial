package org.example.springecommerce.service;

import org.example.springecommerce.exceptions.ProductNotFoundException;
import org.example.springecommerce.model.Order;
import org.example.springecommerce.model.OrderItem;
import org.example.springecommerce.model.Product;
import org.example.springecommerce.model.dto.OrderItemResponse;
import org.example.springecommerce.model.dto.OrderRequest;
import org.example.springecommerce.model.dto.OrderResponse;
import org.example.springecommerce.repo.OrderRepository;
import org.example.springecommerce.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderId("ORD" + UUID.randomUUID().toString().toUpperCase().substring(0, 8));
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        orderRequest.items().forEach(orderItem -> {
            Product product = productRepository
                    .findById(orderItem.productId())
                    .orElseThrow(() -> new ProductNotFoundException(orderItem.productId()));

            product.setStockQuantity(product.getStockQuantity() - orderItem.quantity());
            productRepository.save(product);

            OrderItem orderItemEntity = OrderItem.
                    builder()
                    .product(product)
                    .quantity(orderItem.quantity())
                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(orderItem.quantity())))
                    .order(order)
                    .build();
            orderItems.add(orderItemEntity);
        });

        order.setOrderItems(orderItems);
        Order savedOrder = orderRepository.save(order);

        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()) {
            OrderItemResponse response = new OrderItemResponse(
                    orderItem.getProduct().getName(),
                    orderItem.getQuantity(),
                    orderItem.getTotalPrice()
            );
            orderItemResponses.add(response);
        }

        OrderResponse orderResponse = new OrderResponse(
                savedOrder.getOrderId(),
                savedOrder.getCustomerName(),
                savedOrder.getEmail(),
                savedOrder.getStatus(),
                savedOrder.getOrderDate(),
                orderItemResponses
            );

        return orderResponse;
    }

    public List<OrderResponse> getAllOrderResponses() {
        List<Order>  orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();

        orders.forEach(order -> {
            List<OrderItemResponse> orderItemResponses = new ArrayList<>();

            order.getOrderItems().forEach(orderItem -> {
               OrderItemResponse response = new OrderItemResponse(
                       orderItem.getProduct().getName(),
                       orderItem.getQuantity(),
                       orderItem.getTotalPrice()
               );
               orderItemResponses.add(response);
            });

            OrderResponse orderResponse = new OrderResponse(
                    order.getOrderId(),
                    order.getCustomerName(),
                    order.getEmail(),
                    order.getStatus(),
                    order.getOrderDate(),
                    orderItemResponses
            );
            orderResponses.add(orderResponse);
        });

        return orderResponses;
    }
}
