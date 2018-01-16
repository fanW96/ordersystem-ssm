package com.ordersystem.service.impl;

import com.github.pagehelper.PageHelper;
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
        PageHelper.startPage(2,10);
        return productMapper.showAllProduct();
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
