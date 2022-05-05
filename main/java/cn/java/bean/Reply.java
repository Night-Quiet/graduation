package cn.java.bean;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public class Reply {
    private Long id_reply;
    private Long id_comment;
    private String identify;
    private Long id_user_other;
    private String user_other;
    private String user_other_reply;

    public Reply(Long id_comment, String identify, Long id_user_other, String user_other, String user_other_reply) {
        super();
        this.id_comment = id_comment;
        this.identify = identify;
        this.id_user_other = id_user_other;
        this.user_other = user_other;
        this.user_other_reply = user_other_reply;
    }

    public Reply() {
        super();
    }

    public Long getId_reply() {
        return id_reply;
    }

    public void setId_reply(Long id_reply) {
        this.id_reply = id_reply;
    }

    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Long getId_user_other() {
        return id_user_other;
    }

    public void setId_user_other(Long id_user_other) {
        this.id_user_other = id_user_other;
    }

    public String getUser_other() {
        return user_other;
    }

    public void setUser_other(String user_other) {
        this.user_other = user_other;
    }

    public String getUser_other_reply() {
        return user_other_reply;
    }

    public void setUser_other_reply(String user_other_reply) {
        this.user_other_reply = user_other_reply;
    }
}
