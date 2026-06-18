package com.example.admin_demo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.admin_demo1.common.Result;
import com.example.admin_demo1.entity.SysRole;
import com.example.admin_demo1.entity.SysRolePermission;
import com.example.admin_demo1.service.SysRolePermissionService;
import com.example.admin_demo1.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;
    private final SysRolePermissionService rolePermissionService;

    // 构造注入
    public SysRoleController(SysRoleService sysRoleService,
                             SysRolePermissionService rolePermissionService) {
        this.sysRoleService = sysRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    // 角色列表
    @GetMapping("/list")
    public Result<IPage<SysRole>> list(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        return Result.success(sysRoleService.page(page));
    }

    // 新增角色
    @PostMapping("/add")
    public Result<?> add(@RequestBody SysRole role) {
        sysRoleService.save(role);
        return Result.success();
    }

    // 修改角色
    @PutMapping("/update")
    public Result<?> update(@RequestBody SysRole role) {
        sysRoleService.updateById(role);
        return Result.success();
    }

    // 删除角色
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        sysRoleService.removeById(id);
        return Result.success();
    }

    // ===================== 分配权限（完整可用） =====================
    @PostMapping("/assignPerm")
    public Result<?> assignPerm(@RequestBody Map<String, Object> map) {
        Long roleId = Long.valueOf(map.get("roleId").toString());
        List<Integer> permIdsObj = (List<Integer>) map.get("permIds");
        List<Long> permIds = permIdsObj.stream().map(Integer::longValue).toList();

        // 删除旧权限
        rolePermissionService.remove(new LambdaQueryWrapper<SysRolePermission>()
                .eq(SysRolePermission::getRoleId, roleId));

        // 保存新权限
        for (Long permId : permIds) {
            SysRolePermission rp = new SysRolePermission();
            rp.setRoleId(roleId);
            rp.setPermissionId(permId);
            rolePermissionService.save(rp);
        }
        return Result.success();
    }
}