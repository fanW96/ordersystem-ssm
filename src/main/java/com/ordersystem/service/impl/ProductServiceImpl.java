package com.ordersystem.service.impl;

import com.ordersystem.entity.Product;
import com.ordersystem.mapper.ProductMapper;
import com.ordersystem.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }


    @Override
    public List<Product> showAllProduct() {
        return productMapper.showAllProduct();
    }

    @Override
    public int deleteProduct(int pid) {
        return productMapper.deleteProduct(pid);
    }

    @Override
    public Product detailProduct(int pid) {
        return productMapper.detailProduct(pid);
    }

    @Override
    public List<Product> searchProduct(Product product) {
        return productMapper.searchProduct(product);
    }

    @Override
    public int updateProduct(int pid) {
        return productMapper.updateProduct(pid);
    }

    @Override
    public Product toUpdate(int pid) {
        return productMapper.toUpdate(pid);
    }


    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
