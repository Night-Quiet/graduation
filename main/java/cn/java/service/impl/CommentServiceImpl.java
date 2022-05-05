package cn.java.service.impl;

import cn.java.mapper.CommentMapper;
import cn.java.service.CommentService;
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
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Map<String, Object>> getCommentById(Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        List<Map<String, Object>> comment = commentMapper.getCommentById(paramMap);
        return comment;
    }

    @Override
    public boolean addComment(Long id_question, String identify, Long id_user_main, String user_main, String user_main_comment) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        paramMap.put("identify", identify);
        paramMap.put("id_user_main", id_user_main);
        paramMap.put("user_main", user_main);
        paramMap.put("user_main_comment", user_main_comment);
        boolean judge = commentMapper.addComment(paramMap);
        return judge;
    }

    @Override
    public List<Map<String, Object>> getCommentByUser(Long id_user_main) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user_main", id_user_main);
        List<Map<String, Object>> comment = commentMapper.getCommentByUser(paramMap);
        return comment;
    }

    @Override
    public boolean updateComment(Long id_comment, String user_main_comment) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_comment", id_comment);
        paramMap.put("user_main_comment", user_main_comment);
        boolean judge = commentMapper.updateComment(paramMap);
        return judge;
    }
}
