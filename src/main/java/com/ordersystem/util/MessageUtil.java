package com.ordersystem.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class MessageUtil {
    /**
     * 根据键获取自定义message配置文件的值
     * @param file 配置文件所在路径
     * @param key 键
     * @return
     */
    public static String getMessageValueByKey(String file,String key){
        String content="";
        Properties prop=new Properties();
        try {
            InputStream in=new BufferedInputStream(new FileInputStream(file));
            prop.load(in);
            content=prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("获取Message配置文件时出错："+e.getMessage());
            return "";
        }
        return content;
    }

}
