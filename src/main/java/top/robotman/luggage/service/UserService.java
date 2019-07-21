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

import java.util.List;

@Service
public class UserService {
    public static String PROFILE = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3875965517,2977354600&fm=26&gp=0.jpg";

    @Autowired
    private UserRepository userRepository;

    public Result addUser(UserVO userVO){
        User user = new User();
        user.setUsername(userVO.getPhonenum());
        user.setUserpass(userVO.getPassword());
        user.setUserhimg(PROFILE);
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
