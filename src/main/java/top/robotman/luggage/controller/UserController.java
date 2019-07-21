package top.robotman.luggage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.robotman.luggage.bean.Result;
import top.robotman.luggage.bean.UserVO;
import top.robotman.luggage.service.UserService;
import top.robotman.luggage.util.ResultUtil;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Result regist(@RequestBody UserVO param){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getPhonenum()+ ">>>>>>>>>>>>>>>>>>>>>>>>>");
        Result result = userService.addUser(param);
        //userService.searchUser("");
        return result;
    }
}
