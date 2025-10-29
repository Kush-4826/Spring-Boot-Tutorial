package org.example.springecommerce.controller;

import org.example.springecommerce.model.dto.OrderRequest;
import org.example.springecommerce.model.dto.OrderResponse;
import org.example.springecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController extends ApiController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = this.orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orderResponses = this.orderService.getAllOrderResponses();
        return new ResponseEntity<>(orderResponses, HttpStatus.OK);
    }
}
