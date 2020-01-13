package cn.svenbarnett.dframe.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * [简单描述]
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-13 23:04]
 */

@Controller
public class LoginAction extends BaseController {


    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("login")
    public String dologin() {
        return REDIRECT + "/";
    }

    @GetMapping("logout")
    public String logout() {
        return REDIRECT + "/login";
    }
}
