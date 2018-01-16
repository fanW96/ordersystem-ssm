package com.ordersystem.action;

import com.ordersystem.entity.Category;
import com.ordersystem.service.CategoryService;

import java.util.List;

public class CategoryAction {
    private CategoryService categoryService;
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getAllCategory() {
        categoryList = categoryService.getAllCategory();
        for (Category c: categoryList
             ) {
            System.out.println(c.toString());
        }
        return "getAllCategory_success";
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }


    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
