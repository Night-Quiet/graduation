package cn.java.service;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author:
 * date: 2022/2/17
 */
public interface QuestionService {
    public List<Map<String, Object>> getQuestionByClass(Long id_class);
    public List<Map<String, Object>> getQuestionByUser(Long id_user);
    public List<Map<String, Object>> getQuestionBySummary(String key);
    public Map<String, Object> getQuestionById(Long id_question);
    public Long addQuestion(Long id_class, Long id_user, String question) throws Exception;
    public boolean deleteQuestion(Long id_question);
}
