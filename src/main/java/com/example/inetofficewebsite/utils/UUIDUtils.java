package com.example.inetofficewebsite.utils;

import java.util.UUID;

/**
 * @author zcl
 * @since 2021/9/7
 */
public class UUIDUtils {
    /**
     * 创建数据库主键
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
