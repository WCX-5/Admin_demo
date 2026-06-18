package com.example.admin_demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // 登录页
    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        if (logout != null) {
            model.addAttribute("msg", "退出登录成功");
        }
        return "login";
    }

    // 首页
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // 用户管理
    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    // 角色管理
    @GetMapping("/role")
    public String rolePage() {
        return "role";
    }

    // 权限管理
    @GetMapping("/permission")
    public String permPage() {
        return "permission";
    }

    // 用户分配角色
    @GetMapping("/user-role")
    public String userRolePage() {
        return "user_role";
    }

    // 角色分配权限
    @GetMapping("/role-perm")
    public String rolePermPage() {
        return "role_perm";
    }
}