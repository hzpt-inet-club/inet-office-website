package com.example.inetofficewebsite.utils;

import java.io.File;

/**
 * @author zcl
 * @since 2021/9/8
 */
public class ImgFileUtil {
    /**
     * 活动图片编号
     * @param path 图片路径
     * @return 图片编号
     */
    public static Integer FileNum(String path){
        int sum=1;
        File searchFile=new File(path);
        for (File f: searchFile.listFiles()) {
            if (f.isFile()&&f.getName().contains(".jpg")) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 返回图片路径
     * @param path 图片路径
     * @return 返回所有图片的路径信息
     */
    public static String[] FileImgPath(String path){
        File searchFile=new File(path);
        File[] files=searchFile.listFiles();
        String[] filePaths=new String[files.length];
        for (int i=0;i<filePaths.length;i++) {
            filePaths[i]=files[i].getPath();
            System.out.println(files[i].getPath());
        }
        return filePaths;
    }
}
