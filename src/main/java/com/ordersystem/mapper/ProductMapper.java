package com.ordersystem.mapper;

import com.ordersystem.entity.Product;

import java.util.List;

public interface ProductMapper {
    public int addProduct(Product product);
    public List<Product> showAllProduct();
}
