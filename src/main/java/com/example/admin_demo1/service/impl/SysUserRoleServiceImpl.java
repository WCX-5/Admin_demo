package com.example.admin_demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin_demo1.entity.SysUserRole;
import com.example.admin_demo1.mapper.SysUserRoleMapper;
import com.example.admin_demo1.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}