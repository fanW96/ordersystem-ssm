package com.ordersystem.action;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ordersystem.entity.Category;
import com.ordersystem.entity.Page;
import com.ordersystem.entity.Product;
import com.ordersystem.service.CategoryService;
import com.ordersystem.service.ProductService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAction extends ActionSupport implements SessionAware {
    private ProductService productService;
    private CategoryService categoryService;
    private List<Category> categoryList;
    private Product product;
    private File picture;
    private String pictureContentType;
    private String pictureFileName;
    private String savePath;
    private List<Product> productList;
    private List selectedId;

    public List getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(List selectedId) {
        this.selectedId = selectedId;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;

    public Map<String,Object> session;

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public String upload(){
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            fis=new FileInputStream (this.getPicture());
            String suffix = pictureFileName.substring(pictureFileName.lastIndexOf(".") + 1);
            String tmp = "a"+df.format(new Date())+(int)(10+Math.random()*(99-10+1))+"."+suffix;
            fos= new FileOutputStream(this.getSavePath()+"\\"+tmp);
            byte[] buffer = new  byte[1024];
            int len = 0;
            while ((len=fis.read(buffer))>0){
                fos.write(buffer,0,len);
            }
            //product.setPicture(pictureFileName);
            product.setPicture(tmp);

            if(product.getPid()==0) {
                productService.addProduct(product);
            } else{
                productService.updateProduct(product);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                fos.close();
                fis.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return SUCCESS;
    }


    public String addProduct() {
        productService.addProduct(product);
        return "addProduct_success";
    }

    public String showAllProduct() {
        productList = productService.showAllProduct();
        return "showAllProduct";
    }

    public String deleteProduct() {
        if(productService.deleteProduct(product.getPid()) == 1){
            productList = productService.showAllProduct();
            return "deleteProduct";
        }
        return "failure";
    }

    public String putOnShelves() {
        if(productService.putOnShelves(selectedId) == 1){
            productList = productService.showAllProduct();
            return "putOnShelves";
        }
        return "fail";
    }

    public String pullOffShelves() {
        if(productService.pullOffShelves(selectedId) == 1){
            productList = productService.showAllProduct();
            return "pullOffShelves";
        }
        return "fail";
    }

    public String detailProduct() {
        product = productService.detailProduct(product.getPid());
        if(product != null) {
            return "detailProduct";
        }
        return "fail";
    }

    public String searchProduct() {
        productList = productService.searchProduct(product);
        System.out.println("name="+product.getPname());
        return "searchProduct";
    }

    public String toUpdate() {
        product = productService.toUpdate(product.getPid());
        categoryList = categoryService.getAllCategory();
        if(product!=null&&categoryList!=null) {
            return "toUpdate";
        }
        return "failure";
    }



    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String toAddProduct() {
        return "toAddProduct";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
