package com.cskaoyan.mall.mapper;

import org.apache.ibatis.annotations.Select;

public interface Permission_DetailsMapper {
    @Select("select id from cskaoyan_mall_permission_details where pid > 100")
    String[] selectId();
}
