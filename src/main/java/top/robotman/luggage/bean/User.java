package top.robotman.luggage.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "user") // 指定关联的数据库的表名
public class User implements Serializable {
    /*用户id*/
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String  id;
    /*用户名*/
    @Column(length = 30,unique  = true,nullable = false)
    private String username;
    /*用户密码*/
    private String userpass;
    /*用户头像*/
    private String userhimg;
    /*用户昵称*/
    private String nickname;

    public User() {
    }

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUserhimg() {
        return userhimg;
    }

    public void setUserhimg(String userhimg) {
        this.userhimg = userhimg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
