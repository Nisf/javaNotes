package com.nisifan.java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// PirntWriter: 属于输出流,针对字符流; 而相对的PrintStream是针对字节流
// 只能写数据，不能读数据
public class DemoPrintWriter {
    public static void main(String[] args) throws IOException {
        // 创建一个字符打印流对象
        PrintWriter pw = new PrintWriter(new FileWriter("IO流/src/com/nisifan/java/output.txt")); //如文件不存在，会自动创建
        System.out.println(pw.toString());
        pw.print("哈哈哈");
        pw.println("helloworld");
        pw.flush(); // 将缓冲区里的数据强制输出
        pw.close();
    }
}
