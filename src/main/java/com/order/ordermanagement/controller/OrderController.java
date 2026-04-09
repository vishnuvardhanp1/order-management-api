/**
 * 
 */
package com.order.ordermanagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OrderController {

    @GetMapping
    public String test() {
        return "Order API Working 🚀";
    }
}
