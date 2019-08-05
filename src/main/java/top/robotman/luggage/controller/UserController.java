package top.robotman.luggage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.robotman.luggage.bean.Result;
import top.robotman.luggage.bean.User;
import top.robotman.luggage.bean.UserVO;
import top.robotman.luggage.service.UserService;
import top.robotman.luggage.util.ResultEnum;
import top.robotman.luggage.util.ResultUtil;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Result regist(@RequestBody UserVO param){
        Result result = userService.addUser(param);
        //userService.searchUser("");
        return result;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody UserVO param){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getPhonenum()+ ">>>>>>>>>>>>>>>>>>>>>>>>>");
        User user =  userService.searchUser(param.getPhonenum());
        Result result = null;
        if(user == null){
            result = ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
            //账号不存在
        }else {
            if(user.getUserpass().equals(param.getPassword())){
                result = ResultUtil.success(user);
            }else{
                result = ResultUtil.error(ResultEnum.ERROR_PASSWORD.getCode(),ResultEnum.ERROR_PASSWORD.getMsg());
                //密码或账号错误
            }
        }
        return result;
    }
}
