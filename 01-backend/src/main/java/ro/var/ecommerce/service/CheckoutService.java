package ro.var.ecommerce.service;


import ro.var.ecommerce.dto.Purchase;
import ro.var.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
