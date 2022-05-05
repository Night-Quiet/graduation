package cn.java.bean;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public class Comment {
    private Long id_comment;
    private Long id_question;
    private String identify;
    private Long id_user_main;
    private String user_main;
    private String user_main_comment;

    public Comment(Long id_question, String identify, Long id_user_main, String user_main, String user_main_comment) {
        super();
        this.id_question = id_question;
        this.identify = identify;
        this.id_user_main = id_user_main;
        this.user_main = user_main;
        this.user_main_comment = user_main_comment;
    }

    public Comment() {
        super();
    }

    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Long getId_user_main() {
        return id_user_main;
    }

    public void setId_user_main(Long id_user_main) {
        this.id_user_main = id_user_main;
    }

    public String getUser_main() {
        return user_main;
    }

    public void setUser_main(String user_main) {
        this.user_main = user_main;
    }

    public String getUser_main_comment() {
        return user_main_comment;
    }

    public void setUser_main_comment(String user_main_comment) {
        this.user_main_comment = user_main_comment;
    }
}
