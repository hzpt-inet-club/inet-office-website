package com.example.inetofficewebsite.controller;

import com.example.inetofficewebsite.result.Result;
import com.example.inetofficewebsite.utils.ImgFileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *     前端控制器
 * </p>
 * @author  zcl
 * @since 2021/9/8s
 */
@RestController
public class ImgController {
    /**
     *
     * @param imgFile 接收前端上传的图片
     * @return 返回路径，用于前端删除图片
     * @throws IOException 抛出io流异常
     */
    @PostMapping("/addImg")
    public Result addImg(@RequestParam("img_file") MultipartFile imgFile) throws IOException {
        String path = "src/main/resources/static/img";
        File imgFolder=new File(path);
        if (!imgFolder.exists())
            imgFolder.mkdir();
        InputStream fis=imgFile.getInputStream();
        File img = new File(path+"/"+ "activity_img_"+(ImgFileUtil.FileNum(path)) +".jpg");
        FileOutputStream fos=new FileOutputStream(img);
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
        return new Result().result200(ImgFileUtil.FileImgPath(path));
    }

    /**
     * 删除活动图片
     * @param imgPath 要删除的图片的路径
     * @return 返回删除后剩余图片的路径
     */
    @DeleteMapping("/deleteImg")
    public Result deleteImg(@RequestParam("img_path")String imgPath){
        String path = "src/main/resources/static/img";
        File file=new File(imgPath);
        System.out.println(file.delete());
        return new Result().result200(ImgFileUtil.FileImgPath(path));
    }
}
