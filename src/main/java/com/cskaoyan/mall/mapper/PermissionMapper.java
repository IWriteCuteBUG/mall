package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Permission;
import com.cskaoyan.mall.bean.PermissionExample;
import java.util.List;

import com.cskaoyan.mall.bean.System;
import com.cskaoyan.mall.vo.dhd.util.PermissionsUpdateBean;
import com.cskaoyan.mall.vo.dhd.util.SystemPermission;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    String[]  selectPermissionByRoleId(@Param("id") int id);
    List<SystemPermission> selectAdminPermission_details(@Param("id") int id);

    List<SystemPermission> selectAdminPermission_detailsParent();
    void deletePermission(@Param("id") int id);
    int insertPermission(@Param("id")int roleid,@Param("permission") String permission);
}