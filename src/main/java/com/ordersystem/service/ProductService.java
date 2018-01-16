package com.ordersystem.service;

import com.ordersystem.entity.Product;

import java.util.List;

public interface ProductService {
    public int addProduct(Product product);
    public List<Product> showAllProduct();
}
