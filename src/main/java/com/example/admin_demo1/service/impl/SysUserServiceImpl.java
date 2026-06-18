package com.example.admin_demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admin_demo1.entity.SysUser;
import com.example.admin_demo1.mapper.SysUserMapper;
import com.example.admin_demo1.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}