package com.example.admin_demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin_demo1.entity.SysRole;
import com.example.admin_demo1.mapper.SysRoleMapper;
import com.example.admin_demo1.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}