package com.example.admin_demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin_demo1.entity.SysPermission;
import com.example.admin_demo1.mapper.SysPermissionMapper;
import com.example.admin_demo1.service.SysPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
}