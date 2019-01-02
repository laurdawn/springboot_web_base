package com.laurdawn.website.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurdawn.website.entity.Role;
import com.laurdawn.website.enums.EResultType;
import com.laurdawn.website.service.IRoleService;

/**
 * 角色管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;
    
    /**
     * 添加角色
     * @param entity
     * @return
     */
    @RequestMapping("/save")
    public String save(Role entity){
    	roleService.saveRole(entity);
    	return retResultData(EResultType.SUCCESS);
    }
    
    /**
     * 获取所有角色
     * @return
     */
    @RequestMapping("/getAll")
    public String getAll(){
    	List<Role> allRole = roleService.findAllRole();
    	return retResultData(EResultType.SUCCESS, allRole);
    }
    
    /**
     * 修改角色（角色名）
     * @param entity
     * @return
     */
    @RequestMapping("/modify")
    public String modify(Role entity){
    	roleService.modifyRole(entity);
    	return retResultData(EResultType.SUCCESS);
    }
    
    /**
     * 删除角色
     * （同时删除角色权限）
     */
    @RequestMapping("/delete")
    public String delete(Role entity){
    	roleService.deleteRole(entity.getId());
    	return retResultData(EResultType.SUCCESS);
    }

}
