package com.ordersystem.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ordersystem.entity.Product;
import com.ordersystem.service.ProductService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ProductAction extends ActionSupport implements SessionAware {
    private  ProductService productService;
    private  Product product;
    private File picture;
    private String pictureContentType;
    private String pictureFileName;
    private String savePath;
    List<Product> productList;

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
            //文件输出
            fos= new FileOutputStream(this.getSavePath()+"\\"+this.getPictureFileName());
            fis=new FileInputStream (this.getPicture());
            byte[] buffer = new  byte[1024];
            int len = 0;
            while ((len=fis.read(buffer))>0){
                fos.write(buffer,0,len);
            }
            product.setPicture(pictureFileName);
            productService.addProduct(product);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
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
        for (Product p:productList
             ) {
            System.out.println(p.toString());
        }
        return "showAllProduct";
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

    public Map<String,Object> session;

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
