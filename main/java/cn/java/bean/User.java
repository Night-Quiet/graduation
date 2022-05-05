package cn.java.bean;

/**
 * description:
 * author:宋琪
 * date: 01/06/2021
 */
public class User {
    private Long id_user;
    private String username;
    private String password;
    private Long id_identify;
    private Long id_class;
    public User(String username, String password, Long id_identify, Long id_class) {
        super();
        this.username = username;
        this.password = password;
        this.id_identify = id_identify;
        this.id_class = id_class;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId_identify() {
        return id_identify;
    }

    public void setId_identify(Long id_identify) {
        this.id_identify = id_identify;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    @Override
    public String toString() {
        return "User [id_user=" + id_user + ", username=" + username + ", password=" + password + "]";
    }

    }
