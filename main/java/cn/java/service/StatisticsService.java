package cn.java.service;

import jnr.ffi.annotations.In;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/14
 */
public interface StatisticsService {
    public boolean haveView(Long id_user, Long id_question);
    public boolean addStatistics(Long id_user, Long id_question, Integer identify);
    public boolean updateIsComment(Long id_user, Long id_question, Integer is_comment);
    public boolean updateIsReply(Long id_user, Long id_question, Integer is_reply);
    public List<Map<String, Object>> getStatisticsByUser(Long id_user);
    public List<Map<String, Object>> getStatisticsByQuestion(Long id_question, Integer identify);
}
