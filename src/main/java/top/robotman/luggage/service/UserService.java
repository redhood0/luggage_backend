package top.robotman.luggage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import top.robotman.luggage.bean.User;
import top.robotman.luggage.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(){
        User user = new User();
        user.setUsername("sb");
        user.setUserpass("11222121");
        User user1 = userRepository.save(user);
        return user1;
    }

    public List<User> searchUser(@RequestParam(value = "user_name", required = false,
            defaultValue = "张少林")String username){
        List<User> users = userRepository.findByUsername("sb");
        return users;
    }

}
