package cn.java.mapper;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public interface ReplyMapper {
    // 依靠评论Id查询评论回复
    public List<Map<String, Object>> getReplyById(Map<String, Object> map);

    // 添加评论回复
    public boolean addReply(Map<String, Object> map);

    // 通过用户Id查询用户回复
    public List<Map<String, Object>> getReplyByUser(Map<String, Object> map);

    // 根据回复Id更改问题回复
    public boolean updateReply(Map<String, Object> map);
}
