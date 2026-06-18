package com.example.admin_demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.admin_demo1.common.Result;
import com.example.admin_demo1.entity.SysUser;
import com.example.admin_demo1.entity.SysUserRole;
import com.example.admin_demo1.service.SysUserRoleService;
import com.example.admin_demo1.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService sysUserService;
    private final SysUserRoleService userRoleService;

    // 构造注入
    public SysUserController(SysUserService sysUserService,
                             SysUserRoleService userRoleService) {
        this.sysUserService = sysUserService;
        this.userRoleService = userRoleService;
    }

    // 用户列表
    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<IPage<SysUser>> list(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        IPage<SysUser> userPage = sysUserService.page(page);
        return Result.success(userPage);
    }

    // 新增用户
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<?> add(@RequestBody SysUser user) {
        sysUserService.save(user);
        return Result.success();
    }

    // 修改用户
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<?> update(@RequestBody SysUser user) {
        sysUserService.updateById(user);
        return Result.success();
    }

    // 删除用户
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<?> delete(@PathVariable Long id) {
        sysUserService.removeById(id);
        return Result.success();
    }

    // ===================== 分配角色（完整可用） =====================
    @PostMapping("/assignRole")
    @PreAuthorize("hasRole('ADMIN')")
    public Result<?> assignRole(@RequestBody Map<String, Object> map) {
        Long userId = Long.valueOf(map.get("userId").toString());
        List<Integer> roleIdsObj = (List<Integer>) map.get("roleIds");
        List<Long> roleIds = roleIdsObj.stream().map(Integer::longValue).toList();

        // 删除旧角色
        userRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, userId));

        // 保存新角色
        for (Long roleId : roleIds) {
            SysUserRole ur = new SysUserRole();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            userRoleService.save(ur);
        }
        return Result.success();
    }
}