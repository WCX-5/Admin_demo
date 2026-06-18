package com.example.admin_demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin_demo1.entity.SysRolePermission;
import com.example.admin_demo1.mapper.SysRolePermissionMapper;
import com.example.admin_demo1.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
}