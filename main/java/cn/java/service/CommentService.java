package cn.java.service;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
public interface CommentService {
    public List<Map<String, Object>> getCommentById(Long id_question);
    public boolean addComment(Long id_question, String identify, Long id_user_main, String user_main, String user_main_comment);
    public List<Map<String, Object>> getCommentByUser(Long id_user_main);
    public boolean updateComment(Long id_comment, String user_main_comment);
}
