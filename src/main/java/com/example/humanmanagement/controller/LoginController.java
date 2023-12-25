package com.example.humanmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.example.humanmanagement.Service.UserService;
import com.example.humanmanagement.domain.ApiResponse;
import com.example.humanmanagement.domain.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    private UserService userService;

    @Autowired
    public void getUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String hello(Model model) {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session, HttpServletRequest request) {
        String sessionId = session.getId();
        String deviceId = request.getHeader("User-Agent");

//        log.warn("sessionId is {}, deviceId is {}", sessionId, deviceId);
        String password = loginRequest.getPassword();
        String username = loginRequest.getUsername();
        boolean validUser = userService.isValidUser(username, password);
        // 假设你有一个用于验证的服务类

        if (validUser) {
            String s = JSON.toJSONString(ApiResponse.success());
            return s;
        } else {
            String s = JSON.toJSONString(ApiResponse.notFound());
            return s;
        }
    }
}
