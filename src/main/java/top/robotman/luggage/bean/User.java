package top.robotman.luggage.bean;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "user") // 指定关联的数据库的表名
public class User implements Serializable {
    /*用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*用户名*/
    @Column(length = 30,nullable = false)
    private String username;
    /*用户密码*/
    private String userpass;
    /*用户头像*/
    private String userhimg;
    /*用户昵称*/
    private String nickname;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
