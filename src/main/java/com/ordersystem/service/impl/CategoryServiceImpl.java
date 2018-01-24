package com.ordersystem.service.impl;

import com.ordersystem.entity.Category;
import com.ordersystem.mapper.CategoryMapper;
import com.ordersystem.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryMapper categoryMapper;

    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    public CategoryMapper getCategoryMapper() {
        return categoryMapper;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
}
