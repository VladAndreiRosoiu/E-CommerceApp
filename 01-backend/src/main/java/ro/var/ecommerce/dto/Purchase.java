package ro.var.ecommerce.dto;

import lombok.Data;
import ro.var.ecommerce.models.Address;
import ro.var.ecommerce.models.Customer;
import ro.var.ecommerce.models.Order;
import ro.var.ecommerce.models.OrderItem;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem > orderItems;
}
