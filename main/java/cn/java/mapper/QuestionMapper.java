package cn.java.mapper;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author:
 * date: 2022/2/17
 */
public interface QuestionMapper {
    // 通过班级查询问题
    public List<Map<String, Object>> getQuestionByClass(Map<String, Object> map);

    // 通过学生id查询个人问题
    public List<Map<String, Object>> getQuestionByUser(Map<String, Object> map);

    // 通过问题摘要查询问题
    public List<Map<String, Object>> getQuestionBySummary(Map<String, Object> map);

    // 通过问题id查询问题
    public Map<String, Object> getQuestionById(Map<String, Object> map);

    // 插入问题数据
    public Long addQuestion(Map<String, Object> map);

    // 查询最新问题id
    public Long getQuestionId();

    // 依靠 问题Id 删除问题
    public boolean deleteQuestion(Map<String, Object> map);

}
