package com.tjudream.demo.controller;

import com.alibaba.fastjson.JSON;
import com.tjudream.demo.model.ErrorMsg;
import com.tjudream.demo.model.User;
import com.tjudream.demo.service.UserService;
import com.tjudream.demo.util.PubUtil;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-04-08 10:43
 *
 * @author mengxs@lenovocloud.com
 */
@Api(value = "/user", description = "用户资源", position = 1)
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id获取用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class),
            @ApiResponse(code = 403, message = "没有权限"),
            @ApiResponse(code = 404, message = "用户不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void getUserById(
            @ApiParam(value = "用户id", required = true, defaultValue = "1")
            @PathVariable(value = "id") Integer id,
            HttpServletRequest req, HttpServletResponse resp
    ) throws IOException {
        logger.info("id is {}", id);
        User user = this.userService.getUserById(id);
        if (user == null) {
            ErrorMsg errorMsg = new ErrorMsg(10001, "没找到此用户");
            resp.setStatus(HttpStatus.NOT_FOUND.value());
            resp.getWriter().write(JSON.toJSONString(errorMsg));
        } else {
            PubUtil.responseText(resp, JSON.toJSONString(user));
        }
    }

}
