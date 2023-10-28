package com.dennys.ecommerce.dto;

import lombok.Data;

import java.util.Set;

import com.dennys.ecommerce.entity.Address;
import com.dennys.ecommerce.entity.Customer;
import com.dennys.ecommerce.entity.Order;
import com.dennys.ecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
