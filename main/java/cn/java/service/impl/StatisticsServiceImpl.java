package cn.java.service.impl;

import cn.java.mapper.StatisticsMapper;
import cn.java.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/14
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    StatisticsMapper statisticsMapper;

    @Override
    public boolean haveView(Long id_user, Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        paramMap.put("id_question", id_question);
        Map<String, Object> numView = statisticsMapper.haveView(paramMap);
        int isHaveView = Integer.valueOf(numView.get("num").toString());
        if (isHaveView <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean addStatistics(Long id_user, Long id_question, Integer identify) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        paramMap.put("id_question", id_question);
        paramMap.put("identify", identify);
        boolean judge = statisticsMapper.addStatistics(paramMap);
        return judge;
    }

    @Override
    public boolean updateIsComment(Long id_user, Long id_question, Integer is_comment) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        paramMap.put("id_question", id_question);
        paramMap.put("is_comment", is_comment);
        boolean judge = statisticsMapper.updateIsComment(paramMap);
        return judge;
    }

    @Override
    public boolean updateIsReply(Long id_user, Long id_question, Integer is_reply) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        paramMap.put("id_question", id_question);
        paramMap.put("is_reply", is_reply);
        boolean judge = statisticsMapper.updateIsReply(paramMap);
        return judge;
    }

    @Override
    public List<Map<String, Object>> getStatisticsByUser(Long id_user) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        List<Map<String, Object>> userView = statisticsMapper.getStatisticsByUser(paramMap);
        return userView;
    }

    @Override
    public List<Map<String, Object>> getStatisticsByQuestion(Long id_question, Integer identify) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        paramMap.put("identify", identify);
        List<Map<String, Object>> questionView = statisticsMapper.getStatisticsByQuestion(paramMap);
        return questionView;
    }
}
