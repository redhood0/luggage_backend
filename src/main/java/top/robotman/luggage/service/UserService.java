package top.robotman.luggage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import top.robotman.luggage.bean.Result;
import top.robotman.luggage.bean.User;
import top.robotman.luggage.bean.UserVO;
import top.robotman.luggage.repository.UserRepository;
import top.robotman.luggage.util.ResultEnum;
import top.robotman.luggage.util.ResultUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    public static String PROFILE = "http://imgsrc.baidu.com/forum/pic/item/12c09845d688d43f482a5a3a761ed21b0cf43bbf.jpg";

    @Autowired
    private UserRepository userRepository;

    public Result addUser(UserVO userVO){
        User user = new User();
        user.setUsername(userVO.getPhonenum());
        user.setUserpass(userVO.getPassword());
        user.setUserhimg(PROFILE);
        user.setNickname(userVO.getPhonenum());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        user.setRegistTime(df.format(new Date()));
        User user1;
        try{
            user1 = userRepository.save(user);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg());
        }
        return ResultUtil.success(user1);
    }

    public List<User> searchUser(@RequestParam(value = "user_name", required = false,
            defaultValue = "张少林")String username){
        List<User> users = userRepository.findByUsername("sb");
        return users;
    }

}
