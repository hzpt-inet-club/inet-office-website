package com.example.inetofficewebsite;

import com.example.inetofficewebsite.utils.ImgFileUtil;
import com.example.inetofficewebsite.utils.UUIDUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestClass {
    @Test
    public void test1(){
        File a=new File("src/main/resources/img");
        System.out.println(a.mkdir());
    }
    @Test
    public void test2(){
        System.out.println(UUIDUtils.getUUID());
        System.out.println(UUIDUtils.getUUID().length());
    }

    @Test void test3(){
        System.out.println(ImgFileUtil.FileNum("src/main/resources/static/img"));
    }

    @Test void test4(){
        ImgFileUtil.FileImgPath("src/main/resources/static/img");
    }
}
