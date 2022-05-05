package cn.java.service.impl;

import cn.java.mapper.ReplyMapper;
import cn.java.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Map<String, Object>> getReplyById(Long id_comment) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_comment", id_comment);
        List<Map<String, Object>> reply = replyMapper.getReplyById(paramMap);
        return reply;
    }

    @Override
    public boolean addReply(Long id_comment, String identify, Long id_user_other, String user_other, String user_other_reply) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_comment", id_comment);
        paramMap.put("identify", identify);
        paramMap.put("id_user_other", id_user_other);
        paramMap.put("user_other", user_other);
        paramMap.put("user_other_reply", user_other_reply);
        boolean judge = replyMapper.addReply(paramMap);
        return judge;
    }

    @Override
    public List<Map<String, Object>> getReplyByUser(Long id_user_other) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user_other", id_user_other);
        List<Map<String, Object>> reply = replyMapper.getReplyByUser(paramMap);
        return reply;
    }

    @Override
    public boolean updateReply(Long id_reply, String user_other_reply) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_reply", id_reply);
        paramMap.put("user_other_reply", user_other_reply);
        boolean judge = replyMapper.updateReply(paramMap);
        return judge;
    }
}
