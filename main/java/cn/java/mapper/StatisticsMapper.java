package cn.java.mapper;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/14
 */
public interface StatisticsMapper {
    // 查询用户是否浏览过
    public Map<String, Object> haveView(Map<String, Object> map);

    // 插入浏览数据
    public boolean addStatistics(Map<String, Object> map);

    // 更新是否评论
    public boolean updateIsComment(Map<String, Object> map);

    // 更新是否回复
    public boolean updateIsReply(Map<String, Object> map);

    // 通过学生id查询个人浏览记录
    public List<Map<String, Object>> getStatisticsByUser(Map<String, Object> map);

    // 通过问题id | 身份 查询问题访问记录
    public List<Map<String, Object>> getStatisticsByQuestion(Map<String, Object> map);
}
