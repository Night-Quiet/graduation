package cn.java.bean;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/9
 */
public class Detail {
    private Long id_question;
    private String question;
    private String answer;
    private String q_pic1;
    private String q_pic2;
    private String q_pic3;
    private String a_pic1;
    private String a_pic2;
    private String a_pic3;
    private String a_video;

    public Detail(Long id_question, String question, String answer, String q_pic1, String q_pic2, String q_pic3, String a_pic1, String a_pic2, String a_pic3, String a_video) {
        super();
        this.id_question = id_question;
        this.question = question;
        this.answer = answer;
        this.q_pic1 = q_pic1;
        this.q_pic2 = q_pic2;
        this.q_pic3 = q_pic3;
        this.a_pic1 = a_pic1;
        this.a_pic2 = a_pic2;
        this.a_pic3 = a_pic3;
        this.a_video = a_video;
    }

    public Detail() {
        super();
    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQ_pic1() {
        return q_pic1;
    }

    public void setQ_pic1(String q_pic1) {
        this.q_pic1 = q_pic1;
    }

    public String getQ_pic2() {
        return q_pic2;
    }

    public void setQ_pic2(String q_pic2) {
        this.q_pic2 = q_pic2;
    }

    public String getQ_pic3() {
        return q_pic3;
    }

    public void setQ_pic3(String q_pic3) {
        this.q_pic3 = q_pic3;
    }

    public String getA_pic1() {
        return a_pic1;
    }

    public void setA_pic1(String a_pic1) {
        this.a_pic1 = a_pic1;
    }

    public String getA_pic2() {
        return a_pic2;
    }

    public void setA_pic2(String a_pic2) {
        this.a_pic2 = a_pic2;
    }

    public String getA_pic3() {
        return a_pic3;
    }

    public void setA_pic3(String a_pic3) {
        this.a_pic3 = a_pic3;
    }

    public String getA_video() {
        return a_video;
    }

    public void setA_video(String a_video) {
        this.a_video = a_video;
    }
}
