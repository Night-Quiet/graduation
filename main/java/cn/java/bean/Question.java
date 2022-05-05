package cn.java.bean;

/**
 * description:
 * author:
 * date: 2022/2/17
 */
public class Question {
    private Long id_question;
    private Long id_class;
    private Long id_user;
    private String keyword;
    private Long datenow;

    public Question(Long id_class, Long id_user, String keyword, Long datenow) {
        super();
        this.id_class = id_class;
        this.id_user = id_user;
        this.keyword = keyword;
        this.datenow = datenow;
    }

    public Question() {
        super();
    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String key) {
        this.keyword = keyword;
    }

    public Long getDatenow() {
        return datenow;
    }

    public void setDatenow(Long date) {
        this.datenow = datenow;
    }

    @Override
    public String toString() {
        return "Question [id_question=" + id_question + ", id_class=" + id_class + ", id_user" + id_user + "]";
    }

}
