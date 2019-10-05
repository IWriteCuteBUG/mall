package com.cskaoyan.mall.util.utiLJW;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PhotoUploadUtils {
    public  static  String upload(MultipartFile file){
        String destFileName=null;
        String fileName=null;
        try {
            //根据时间创建新的文件名
            fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //通过System.getProperty("user.dir") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName  = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\"  + fileName;
            //创建目录
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //把浏览器上传的文件复制到目录下
            file.transferTo(destFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "http://localhost/static/"+fileName;
    }
}
