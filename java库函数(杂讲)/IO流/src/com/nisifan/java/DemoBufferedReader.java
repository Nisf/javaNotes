package com.nisifan.java;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoBufferedReader {
    static public void ReadLinesFromFile(String filename) {
        BufferedReader br = null;

        try {
            //构建bufferreader对象
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "IO流/src/com/nisifan/java/" + "br.txt";
        DemoBufferedReader.ReadLinesFromFile(fileName);
    }
}
