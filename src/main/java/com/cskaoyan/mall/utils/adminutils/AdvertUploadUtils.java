package com.cskaoyan.mall.utils.adminutils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class AdvertUploadUtils {


    /**
     * 文件上传的工具类
     */
    public static String upload(MultipartFile myfile,String uploadString) throws IOException {
        //文件名称需要做一个处理，保证每一个文件不会与其他文件重名
        //用户的id -_ fileName
        //当前的时间戳加上一些序列数2019082411254790
        String uuid = UUID.randomUUID().toString();
        String fileName = myfile.getOriginalFilename();
        fileName = uuid + "-" + fileName;
//        将文件夹的名字变为散列值
        int fileNameHashCode = fileName.hashCode();
//        将哈希值转换为十六进制的数
        String hexString = Integer.toHexString(fileNameHashCode);
//        转换为字符数组
        char[] chars = hexString.toCharArray();
//        用于去掉磁盘目录的头
        String oldUploadString = uploadString;
        for (char aChar : chars) {
            uploadString = uploadString + "/" + aChar;
        }
        File file = new File(uploadString +"/"+ fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        myfile.transferTo(file);
        String replace = uploadString.replace(oldUploadString, "");
        return replace +"/"+ fileName;
    }
}

