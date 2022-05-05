package cn.java.service;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public interface ReplyService {
    public List<Map<String, Object>> getReplyById(Long id_comment);
    public boolean addReply(Long id_comment, String identify, Long id_user_other, String user_other, String user_other_reply);
    public List<Map<String, Object>> getReplyByUser(Long id_user_other);
    public boolean updateReply(Long id_reply, String user_other_reply);
}
