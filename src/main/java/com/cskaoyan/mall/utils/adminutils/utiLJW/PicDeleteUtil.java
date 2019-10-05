package com.cskaoyan.mall.util.utiLJW;

import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PicDeleteUtil {
//    public static void main(String[] args) {
//        PicDeleteUtil.redict("http://192.168.3.50/img/7/6/2/7/b/9/1/2/c9bdfb59-cf1a-4f64-9615-8598a73d1096-9.jpg");
//PicDeleteUtil.delete("1");
//    }

    public  static boolean redict( String  picurl){
        //获取ip
        String ip=picurl.substring(picurl.indexOf("http://")+7,picurl.indexOf("/img"));
        //获取C:/static/img下的文件目录
        String catalog=picurl.substring(picurl.indexOf("img/")+4,picurl.lastIndexOf("/"));

        RestTemplate restTemplate = new RestTemplate();
        Map map = new HashMap();
        map.put("catalog",catalog);
      //发送带文件目录（catalog）的get请求
       try {
           String str=restTemplate.getForObject("http://"+ip+":80/deletepic?catalog={catalog}",String.class,map);

       }
       catch (Exception e){
           e.printStackTrace();
       }
        //        String str1=restTemplate.getForObject("http://localhost:80/loginServlet?id={id}",String.class,18);
   return  true;

    }




    public  static String delete(String catalog){
        catalog="e\\5\\b\\8\\b\\4\\d\\d/07b3f49d-96e1-44e7-b1ea-e097246f5f25-9.jpg";
        File file=new File("C:/static/img/"+catalog);

        for (int i=0;i<9;i++){
               file.delete();
               file=file.getParentFile();
           }


        return  "本地文件删除成功";

    }
}
