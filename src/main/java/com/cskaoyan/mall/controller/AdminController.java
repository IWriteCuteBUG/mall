package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.Vo.dhd.util.CreateBean;
import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.admin.*;
import com.cskaoyan.mall.vo.dhd.util.PermissionsUpdateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/admin/admin/list")
    public BaseRespVo info(int page, int limit,String username){
        BaseRespVo baseRespVo = adminService.adminListInfo(page, limit,username);
        return baseRespVo;
    }
    @Autowired
    LogService service;
    @RequestMapping("/admin/log/list")
    public BaseRespVo Loginfo(int page,int limit,String add_time,String desc,String name){
        BaseRespVo baseRespVo =service.logListInfo(page,limit,name);
        return baseRespVo;
    }
    @Autowired
    RoleService roleService;
    @RequestMapping("/admin/role/list")
    public BaseRespVo Roleinfo(int page,int limit,String add_time,String desc,String name){
        BaseRespVo baseRespVo =roleService.rolListInfo(page,limit,name);
        return baseRespVo;
    }
    @Autowired
    CreateService createService;
    @RequestMapping("/admin/role/create")
    public BaseRespVo CreateInfo(@RequestBody CreateBean createBean){
        BaseRespVo createinfo = createService.createinfo(createBean);
        return createinfo;
    }
    @Autowired
    UpdateService updateService;
    @RequestMapping("/admin/role/update")
    public BaseRespVo updateInfo(@RequestBody Role role){
        BaseRespVo baseRespVo = updateService.UpdateInfo(role);
        return baseRespVo;
    }
    @Autowired
    DeleteRoleService deleteRoleService;
    @RequestMapping("/admin/role/delete")
    public BaseRespVo deletInfo(@RequestBody Role role){
        BaseRespVo baseRespVo=deleteRoleService.deleteRole(role);
        return  baseRespVo;
    }
    @Autowired
    StorageService storageService;
    @RequestMapping("/admin/storage/list")
    public BaseRespVo storageInfo(int page,int limit,String add_time,String desc,String key,String name){
        BaseRespVo baseRespVo = storageService.storageInfo(page, limit, key, name);
        return baseRespVo;
    }
    @Autowired
    StorageUpdageService storageUpdageService;
    @RequestMapping("/admin/storage/update")
    public BaseRespVo storageUpdageInfo(@RequestBody Storage storage){
        BaseRespVo baseRespVo = storageUpdageService.updageStorage(storage);
        return  baseRespVo;
    }
    @Autowired
    DeleteStorage deleteStorage;
    @RequestMapping("/admin/storage/delete")
    public BaseRespVo deleteStorageInfo(@RequestBody Storage storage){
        BaseRespVo baseRespVo = deleteStorage.deleteStorage(storage);
        return  baseRespVo;
    }
    @Autowired
    AdminOptionService adminOptionService;
    @RequestMapping("/admin/role/options")
    public BaseRespVo adminOptionInfo(){
        BaseRespVo baseRespVo=adminOptionService.selectLableList();
        return baseRespVo;
    }
    @Autowired
    AdminCreateService adminCreateService;
    @RequestMapping("/admin/admin/create")
    public BaseRespVo adminCreateInfo(@RequestBody Admin admin){
        BaseRespVo baseRespVo=adminCreateService.createAdmin(admin);
        return baseRespVo;
    }
    @Autowired
    AdminUpdateService adminUpdateService;
    @RequestMapping("/admin/admin/update")
    public BaseRespVo adminUpdateInfo(@RequestBody Admin admin){
        BaseRespVo baseRespVo=adminUpdateService.updateAdmin(admin);
        return baseRespVo;
    }
    @Autowired
    AdminDeleteService adminDeleteService;
    @RequestMapping("/admin/admin/delete")
    public BaseRespVo adminDeleteInfo(@RequestBody Admin admin){
        BaseRespVo baseRespVo=adminDeleteService.deleteAdmin(admin);
        return baseRespVo;
    }
    @Autowired
    AdminPermissionsService adminPermissionsService;
    @RequestMapping(value = "/admin/role/permissions",method = RequestMethod.GET)
    public BaseRespVo adminPermissonInfo(int roleId){
        BaseRespVo baseRespVo=adminPermissionsService.permissionList(roleId);
        return baseRespVo;
    }
    @Autowired
    AdminPermissionUpdateService adminPermissionUpdateService;
    @RequestMapping(value = "/admin/role/permissions",method = RequestMethod.POST)
    public BaseRespVo adminPermissionUpdateInfo(@RequestBody PermissionsUpdateBean permissionsUpdateBean){
        BaseRespVo baseRespVo=adminPermissionUpdateService.updateRolePermission( permissionsUpdateBean);
         return baseRespVo;
    }
}
