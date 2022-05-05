package cn.java.mapper;

import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/9
 */
public interface DetailMapper {
    // 通过问题id查询问题详情
    public Map<String, Object> getDetailById(Map<String, Object> map);

    // 学生添加问题
    public boolean addDetail(Map<String, Object> map);

    // 更新问题
    public boolean updateDetail(Map<String, Object> map);
}
