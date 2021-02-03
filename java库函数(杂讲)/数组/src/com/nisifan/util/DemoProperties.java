package com.nisifan.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
// 主要用于读取格式为“键=值”格式的配置文件 （常为.properties文件）
// 方法：
// 1. getProperty(String key)
// 2. load(InputStream instream): 从输入流中读取属性列表
// 3. setProperty(String key, String value)： 调用hashtable的put方法
// 4. store(OutputStream out, String comments): 与load方法想法
// 5. clear(): 清楚所有装载的键-值对

public class DemoProperties {
    public static String path = "数组/src/com/nisifan/util/";

    //根据key读取value
    public static String GetValueByKey(String path, String key) throws IOException {
        InputStream in = null;
        Properties properties = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            try {
                properties.load(in);
                String value = properties.getProperty(key);
                System.out.println(key + "=" + value);
                return value;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return null;
    }

    // 显示全部信息
    public static void ShowAllProperties(String path) throws IOException {
        Properties pps = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        pps.load(in);
        Enumeration content = pps.propertyNames();
        while (content.hasMoreElements()) {
            String key = (String) content.nextElement();
            String value = pps.getProperty(key);
            System.out.println(key + "=" + value);
        }
        in.close();
    }

    // 增加信息
    public static void addProperty(String path, String key, String value) throws IOException {
        Properties pps = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        pps.load(in);
        OutputStream out = new FileOutputStream(path);
        pps.setProperty(key, value);
        pps.store(out, "add this property");
    }
    public static void main(String[] args) throws IOException {
        String filePath = path + "test.properties";
        addProperty(filePath, "long", "212");
    }
}
