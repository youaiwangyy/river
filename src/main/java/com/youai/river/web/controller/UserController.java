package com.youai.river.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.youai.river.po.user.User;
import com.youai.river.service.UserService;
import com.youai.river.util.ApiLogger;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/v1/novels", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "RequestRestful", httpMethod = "GET", response = JSONObject.class, responseContainer = "Map", notes = "RequestRestful")
    public String requestRestful(@PathVariable long cursor, @PathVariable int size) {

        JSONObject result = new JSONObject();
        result.put("method", RequestMethod.GET.toString());
        result.put("cursor", cursor);
        result.put("size", size);
        return result.toString();
    }

    @RequestMapping(value = "/{uid}/novels/{nid}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "RequestRestful", httpMethod = "GET", response = JSONObject.class, responseContainer = "Map", notes = "RequestRestful")
    public String requestRestfulGet(@PathVariable long uid, @PathVariable long nid,
                                    @RequestParam(value = "cursor", required = false, defaultValue = "-1") long cursor,
                                    @RequestParam(value = "size", required = false, defaultValue = "20") long size) {

        JSONObject result = new JSONObject();
        result.put("method", RequestMethod.GET.toString());
        result.put("uid", uid);
        result.put("nid", nid);
        result.put("cursor", cursor);
        result.put("size", size);
        return result.toString();
    }

    @RequestMapping(value = "/{uid}/novels/{nid}", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "RequestRestful", httpMethod = "PUT", response = JSONObject.class, responseContainer = "Map", notes = "RequestRestful")
    public String requestRestfulPut(@PathVariable long uid, @PathVariable long nid) {

        JSONObject result = new JSONObject();
        result.put("method", RequestMethod.PUT.toString());
        result.put("uid", uid);
        result.put("nid", nid);
        return result.toString();
    }

    @RequestMapping(value = "/{uid}/novels/{nid}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "RequestRestful", httpMethod = "POST", response = JSONObject.class, responseContainer = "Map", notes = "RequestRestful")
    public String requestRestfulPost(@PathVariable long uid, @PathVariable long nid) {

        JSONObject result = new JSONObject();
        result.put("method", RequestMethod.POST.toString());
        result.put("uid", uid);
        result.put("nid", nid);
        return result.toString();
    }
    @RequestMapping(value = "/{uid}/novels/{nid}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "RequestRestful", httpMethod = "DELETE", response = JSONObject.class, responseContainer = "Map", notes = "RequestRestful")
    public String requestRestful(@PathVariable long uid, @PathVariable long nid) {

        JSONObject result = new JSONObject();
        result.put("method", RequestMethod.DELETE.toString());
        result.put("uid", uid);
        result.put("nid", nid);
        return result.toString();
    }

}
