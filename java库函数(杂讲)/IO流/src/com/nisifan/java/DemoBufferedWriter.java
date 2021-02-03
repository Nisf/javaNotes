package com.nisifan.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class DemoBufferedWriter {
    public static void main(String[] args) {
        OutputStreamWriter ops = null; //字符流通向字节流的桥梁，可以使用指定的字符集对字符进行编码
        // InputStreamReader : 字节流通向字符流的桥梁，使用指定的字符集对字节进行解码

        BufferedWriter bw = null;
        File file;
        File newFile;
        String str = "hello!!!!!!!";
        String parentPath = "IO流/src/com/nisifan/java/";
        try {
            String fileName = "bw";
            file = new File(parentPath, fileName + ".txt"); //讲parent路径和child路径进行拼接
            newFile = new File(parentPath, fileName + "new" + ".txt");
            newFile.createNewFile();
            ops = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            bw = new BufferedWriter(ops);
            bw.append(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
