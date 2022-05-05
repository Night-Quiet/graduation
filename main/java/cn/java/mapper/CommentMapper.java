package cn.java.mapper;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public interface CommentMapper {
    // 依靠问题Id查询问题评论
    public List<Map<String, Object>> getCommentById(Map<String, Object> map);

    // 添加问题评论
    public boolean addComment(Map<String, Object> map);

    // 通过用户Id查询用户评论
    public List<Map<String, Object>> getCommentByUser(Map<String, Object> map);

    // 根据评论Id更改问题评论
    public boolean updateComment(Map<String, Object> map);
}
