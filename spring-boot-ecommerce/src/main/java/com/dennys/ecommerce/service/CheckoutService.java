package com.dennys.ecommerce.service;

import com.dennys.ecommerce.dto.PaymentInfo;
import com.dennys.ecommerce.dto.Purchase;
import com.dennys.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
    PaymentIntent createPaymentIntent(PaymentInfo PaymentInfo) throws StripeException;

}
