package com.ordersystem.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;

public class Logger {
    private static String message;

    /**
     * 当使用了Logger的out方法之后，可直接调用此方法获得共通配置文件中的信息内容
     *
     * @return
     */
    public static String getMessage() {
        return message;
    }

    public static void setMessage(String msg) {
        message = msg;
    }

    /**
     * 写日志,如日志文件不存在，则新建。否则在文件末尾追加内容
     *
     * @param type
     *            信息类型，如为null或空值，则默认为error
     * @param actionID
     *            传递信息的action名称
     * @param messageID
     *            信息ID，请从共通表中获取
     * @param source
     *            引发信息的主体名，例如文本框名称
     */
    public static void out(String type, String actionID, String messageID,String source) {
        BufferedWriter bfw = null;
        String content = "";
        try {
            String url = ServletActionContext.getServletContext().getRealPath("\\log\\");
            System.out.println("Logger-------------------------"+url);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String today = format.format(new Date());
            url = url + "\\" + today + "_error.log";
            // System.out.println("log文件url="+url);
            File file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            }
            content = read(url);// 先读出原先的内容，然后追加
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            content += format.format(new Date()) + "    ";
            if (type == null || type.trim().equals(""))
                type = "error";
            content += "[" + type + "](" + actionID + ")" + messageID + ":";
            // 获取message配置文件中的内容
            String messageUrl = ServletActionContext.getServletContext()
                    .getRealPath("\\WEB-INF\\classes\\message.properties");
            // 要写入的消息主体
            String message = MessageUtil.getMessageValueByKey(messageUrl,
                    messageID);
            // System.out.println(message.indexOf("{0}"));
            if (message.indexOf("{0}") >= 0) {
                message = message.replace("{0}", source);
            }
            // 将配置文件中读取到的信息内容保存到公共message变量中
            setMessage(message);
            content += message;
            FileOutputStream fos = new FileOutputStream(url, false);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            bfw = new BufferedWriter(osw);
            bfw.write(content);

            bfw.flush();
        } catch (Exception e) {
            System.out.println("写日志文件错误：" + e.getMessage());
        } finally {
            if (bfw != null) {
                try {
                    bfw.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

    }

    /**
     * 从共通信息表中根据信息ID取出信息内容,如在之前已经使用了out方法，则可 使用getMessage()方法获取结果
     *
     * @param messageID
     *            要取出的信息ID，请从共通表中选择
     * @param source
     *            引发信息的主体名
     * @return 信息内容
     */
    public static String getMessage(String messageID, String source) {
        String content = "";
        try {
            String messageUrl = ServletActionContext.getServletContext()
                    .getRealPath("\\WEB-INF\\classes\\message.properties");

            String message = MessageUtil.getMessageValueByKey(messageUrl,
                    messageID);

            if (message.indexOf("{0}") >= 0) {
                message = message.replace("{0}", source);
            }
            content += message;

        } catch (Exception e) {
            content = "获取信息错误:" + e.getMessage();
            System.out.println("写日志文件错误：" + e.getMessage());
        }
        return content;
    }

    /**
     * 读取文件内容,每读取一行都自动加上换行符
     *
     * @param url
     *            文件路径
     * @return 返回读取的内容。自动在读取的每行加上换行符
     */
    public static String read(String url) {
        String content = "";
        try {
            FileReader reader = new FileReader(url);
            BufferedReader bfr = new BufferedReader(reader);
            String tempString = "";
            while ((tempString = bfr.readLine()) != null) {
                content += tempString + "\r\n";
            }
            bfr.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("文件读取错误：" + e.getMessage());
        }
        return content;
    }

}
