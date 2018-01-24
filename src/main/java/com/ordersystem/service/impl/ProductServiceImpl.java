package com.ordersystem.service.impl;

import com.ordersystem.entity.Product;
import com.ordersystem.mapper.ProductMapper;
import com.ordersystem.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductMapper productMapper;

    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    public List<Product> showAllProduct() {
        return productMapper.showAllProduct();
    }

    public int deleteProduct(int pid) {
        return productMapper.deleteProduct(pid);
    }

    public Product detailProduct(int pid) {
        return productMapper.detailProduct(pid);
    }

    public List<Product> searchProduct(Product product) {
        return productMapper.searchProduct(product);
    }

    public int updateProduct(Product pid) {
        return productMapper.updateProduct(pid);
    }

    public Product toUpdate(int pid) {
        return productMapper.toUpdate(pid);
    }

    public int putOnShelves(List selectedId) {
        return productMapper.putOnShelves(selectedId);
    }

    public int pullOffShelves(List selectedId) {
        return productMapper.pullOffShelves(selectedId);
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
