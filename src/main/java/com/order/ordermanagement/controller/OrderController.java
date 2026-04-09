/**
 * 
 */
package com.order.ordermanagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    public String test() {
        return "Order API Working 🚀";
    }
}
