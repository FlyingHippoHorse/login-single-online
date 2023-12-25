package com.example.humanmanagement.Service;

import com.example.humanmanagement.conf.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {


    private ConfigProperty configProperty;

    @Autowired
    public void setConfigProperty(ConfigProperty configProperty) {
        this.configProperty = configProperty;
    }

    public boolean isValidUser(String username, String password) {
        Map<String, String> users = configProperty.getUsers();
        System.out.println(users);
        // 模拟校验用户信息，实际应用中可能涉及加密等安全处理
        return users.containsKey(username) && users.get(username).equals(password);
//        return false;
    }
}