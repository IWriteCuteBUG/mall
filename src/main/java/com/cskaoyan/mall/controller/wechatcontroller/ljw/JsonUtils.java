//package com.cskaoyan.mall.controller.wechatcontroller.ljw;
//
//import com.alibaba.druid.support.json.JSONUtils;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.cskaoyan.mall.bean.Goods;
//import com.cskaoyan.mall.bean.GoodsExample;
//import com.cskaoyan.mall.mapper.GoodsMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//@Component
//public class JsonUtils {
//
//    public static void main(String[] args) {
//        JsonUtils jsonUtils = new JsonUtils();
//        jsonUtils.testJSONStrToJavaBeanObj();
//    }
//
//    @Autowired
//    GoodsMapper goodsMapper;
//    public   void testJSONStrToJavaBeanObj(){
//
//
//
//        GoodsExample goodsExample=new GoodsExample();
//        GoodsExample.Criteria criteria=goodsExample.createCriteria();
//        criteria.andIdIsNotNull();
//        List<Goods> goodsList=goodsMapper.selectByExample(goodsExample);
//        StringBuilder stringBuilder=new StringBuilder("[");
//        List<Goods> newgoodsList=new LinkedList<>();
//        for (Goods goods:goodsList){
////          stringBuilder.append(  JSON.toJSONString(goods)+",");
//            System.out.println( JSON.toJSONString(goods));
//           newgoodsList.add(JSON.parseObject(   JSON.toJSONString(goods),Goods.class)) ;
//        }
//        System.out.println(1111);
//        System.out.println(newgoodsList.size());
////        stringBuilder.append("]");
////        String goodssss=stringBuilder.toString();
////        goodssss.substring(goodssss.lastIndexOf(","),goodssss.lastIndexOf(",")+1);
//
////
////        JSONArray json = JSONArray.fromObject(jsonuserStr);
////        List<Goods> users= (List<User>)JSONArray.toCollection(json, User.class);
//
//
////        List<Goods> goodsList111 = JSON.parseObject(goodssss, new TypeReference<Goods>() {});
//        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的
//
//
//
//    }
//
//}
