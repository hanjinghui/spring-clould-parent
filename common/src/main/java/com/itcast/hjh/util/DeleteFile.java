package com.itcast.hjh.util;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个需要删除的文件夹路径,这不是格式化盘符，所以只删除文件夹");
        String str = sc.nextLine();
        if(str.length()<=3){//f:\长度不能小于，不然就是删除盘符了
            System.out.println("请重新输入文件夹路径");
        }else{
            File f = new File(str);
            method(f);
        }
        sc.close();
    }
    public static void method(File f){
        //首先判断f是文件还是文件夹
        if(f.isDirectory()){
            //创建文件数组对象
            File[] files = f.listFiles();
            //开始遍历
            for (File key : files) {
                //如果是文件，就直接删除
                if(key.isFile()){
                    key.delete();
                }else{//如果key是文件夹，就递归
                    method(key);//
                }
            }
        }
        //最后删除这个文件夹就可以了
        f.delete();
    }

}
