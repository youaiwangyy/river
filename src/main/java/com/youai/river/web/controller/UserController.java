package com.youai.river.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.youai.river.po.user.User;
import com.youai.river.service.UserService;
import com.youai.river.util.ApiLogger;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户信息", httpMethod = "GET", response = JSONObject.class, responseContainer = "Map", notes = "用户信息")
    public String getUserInfo(@RequestParam(value = "id", required = true) long id) {
        if (id <= 0) {
            return "{\"status\":1001, \"desc\":\"id error\"}";
        }
        User user = userService.getUserById(id);
        ApiLogger.info("User Info:" + JSONObject.toJSONString(user));
        return JSONObject.toJSONString(user);
    }

}
