/**
 * 
 */
package com.order.ordermanagement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.ordermanagement.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	
	List<Order> orders=new ArrayList<>();
	Long idCounter=1L;
	
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		order.setOrderId(idCounter++);
		orders.add(order);
		return order;
	}
	
	@GetMapping
	public List<Order> getOrders() {
	 return orders;	
	}
	
	@PutMapping("/{orderId}")
	public Order updateOrder(@PathVariable Long orderId,@RequestBody Order updateOrder) {
		for(Order order : orders) {
			order.setProductName(updateOrder.getProductName());
			order.setQuantity(updateOrder.getQuantity());
			order.setPrice(updateOrder.getPrice());
			return order;
		}
		
		return null; // if not found
	}
	
	@DeleteMapping("/{orderId}")
	public String deleteOrder(@PathVariable Long orderId) {
	Iterator<Order> iterator=orders.iterator();
	while(iterator.hasNext()) {
		Order order=iterator.next();
		if (order.getOrderId().equals(orderId)) {
            iterator.remove();
            return "Order deleted successfully";
        }
		
	}
	 return "Order not found";
	}
	
	@PatchMapping("/{orderId}")
	public Order patchOrder(@PathVariable Long orderId, @RequestBody Order partialOrder) {

	    for (Order order : orders) {
	        if (order.getOrderId().equals(orderId)) {

	            if (partialOrder.getProductName() != null) {
	                order.setProductName(partialOrder.getProductName());
	            }

	            if (partialOrder.getQuantity() != 0) {
	                order.setQuantity(partialOrder.getQuantity());
	            }

	            if (partialOrder.getPrice() != 0) {
	                order.setPrice(partialOrder.getPrice());
	            }

	            return order;
	        }
	    }

	    return null;
	}

	
 /*   @GetMapping
    public String test() {
        return "Order API Working 🚀";
    }*/
}
