package cn.java.service;

import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/9
 */
public interface DetailService {
    public Map<String, Object> getDetailById(Long id_question);
    public boolean addDetail(Long id_question, String question, String answer, String q_pic1, String q_pic2, String q_pic3, String a_pic1, String a_pic2, String a_pic3, String a_video);
    public String whetherAnswer(Long id_question);
    public boolean updateDetail(Long id_question, String answer, String a_pic1, String a_pic2, String a_pic3, String a_video);
}
