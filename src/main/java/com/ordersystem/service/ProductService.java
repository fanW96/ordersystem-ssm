package com.ordersystem.service;

import com.ordersystem.entity.Product;

import java.util.List;

public interface ProductService {
    public int addProduct(Product product);
    public List<Product> showAllProduct();
    public int deleteProduct(int pid);
    public Product detailProduct(int pid);
    public List<Product> searchProduct(Product product);
    public int updateProduct(int pid);
    public Product toUpdate(int pid);
}
