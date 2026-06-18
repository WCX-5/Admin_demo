package com.example.admin_demo1.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.admin_demo1.common.Result;
import com.example.admin_demo1.entity.SysPermission;
import com.example.admin_demo1.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    private final SysPermissionService sysPermissionService;

    public SysPermissionController(SysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    @GetMapping("/list")
    public Result<IPage<SysPermission>> list(@RequestParam(defaultValue = "1") int pageNum,
                                             @RequestParam(defaultValue = "10") int pageSize) {
        Page<SysPermission> page = new Page<>(pageNum, pageSize);
        return Result.success(sysPermissionService.page(page));
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody SysPermission permission) {
        sysPermissionService.save(permission);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody SysPermission permission) {
        sysPermissionService.updateById(permission);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        sysPermissionService.removeById(id);
        return Result.success();
    }
}