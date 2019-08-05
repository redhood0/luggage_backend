package top.robotman.luggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import top.robotman.luggage.bean.User;

import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByUsername(String username);


}
