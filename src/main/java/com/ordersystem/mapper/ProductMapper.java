package com.ordersystem.mapper;

import com.ordersystem.entity.Product;

import java.util.List;

public interface ProductMapper {
    public int addProduct(Product product);
    public List<Product> showAllProduct();
    public int deleteProduct(int pid);
    public Product detailProduct(int pid);
    public List<Product> searchProduct(Product product);
    public int updateProduct(Product pid);
    public Product toUpdate(int pid);
    public int putOnShelves(List selectedId);
    public int pullOffShelves(List selectedId);
}
