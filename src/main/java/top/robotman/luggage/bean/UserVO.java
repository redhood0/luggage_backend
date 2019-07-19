package top.robotman.luggage.bean;

public class UserVO {
    private String phonenum;
    private String password;

    public UserVO(String phonenum, String password) {
        this.phonenum = phonenum;
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
