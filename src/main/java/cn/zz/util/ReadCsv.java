package cn.zz.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/24 09:22
 * @Description:    本地csv文件的读取
 */

public class ReadCsv {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File("E:\\bank.csv")));
            br = new BufferedReader(new InputStreamReader(in, "utf-8"));//这里如果csv文件编码格式是utf-8,改成utf-8即可
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            List<String> allString = new ArrayList<String>();
            int count = 0;
            //一行行的读取数据
            while ((line = br.readLine()) != null) //读取到的内容给line变量
            {
                count++;
                if (count > 1) {
                    everyLine = line;
                    System.out.println(everyLine);
                    allString.add(everyLine);
                }
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }
}