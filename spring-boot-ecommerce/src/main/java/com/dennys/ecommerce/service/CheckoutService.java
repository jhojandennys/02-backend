package com.dennys.ecommerce.service;

import com.dennys.ecommerce.dto.Purchase;
import com.dennys.ecommerce.dto.PurchaseResponse;


public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
