package com.cskaoyan.mall.util.utiLJW;

import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PicDeleteUtil {


    public  static boolean redict(String picurl){
        //获取ip
        String ip=picurl;
        //获取C:/static/img下的文件目录
        String catalog=picurl;

        RestTemplate restTemplate = new RestTemplate();
        Map map = new HashMap();
        map.put("catalog",catalog);
     //发送get请求
        String str=restTemplate.getForObject("http://"+ip+":80/deletepic?catalog={catalog}",String.class,map);
//        String str1=restTemplate.getForObject("http://localhost:80/loginServlet?id={id}",String.class,18);
   return  true;

    }



    public  static String delete(String catalog){
        File file=new File("C:/static/img/"+catalog);
        while (file.getParent()!="C:/static/img"&&file.getParent()!="C:"){
            file.delete();
            file=file.getParentFile();

        }
        return  "本地文件删除成功";

    }
}
