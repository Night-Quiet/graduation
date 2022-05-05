package cn.java.service.impl;

import cn.java.bean.Question;
import cn.java.mapper.QuestionMapper;
import cn.java.service.QuestionService;
import com.hankcs.hanlp.HanLP;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author:
 * date: 2022/2/17
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Map<String, Object>> getQuestionByClass(Long id_class){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_class", id_class);
        List<Map<String, Object>> classQuestion = questionMapper.getQuestionByClass(paramMap);
        return classQuestion;
    }

    @Override
    public List<Map<String, Object>> getQuestionByUser(Long id_user){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_user", id_user);
        List<Map<String, Object>> userQuestion = questionMapper.getQuestionByUser(paramMap);
        return userQuestion;
    }

    @Override
    public List<Map<String, Object>> getQuestionBySummary(String key){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", key);
        List<Map<String, Object>> summaryQuestion = questionMapper.getQuestionBySummary(paramMap);
        return summaryQuestion;
    }

    @Override
    public Map<String, Object> getQuestionById(Long id_question){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        Map<String, Object> question = questionMapper.getQuestionById(paramMap);
        return question;
    }

    @Override
    public Long addQuestion(Long id_class, Long id_user, String question) throws Exception {
        // 问题摘要提取
        List<String> keywordList = HanLP.extractSummary(question, 1);
        String key_save = "";
        for (String key: keywordList) {
            key_save = key_save.concat(key);
        }

        // 时间提取
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time1 = timestamp.toString();
        String date_now = time1.substring(0, time1.indexOf(" "));

        // 存储,返回问题Id
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_class", id_class);
        paramMap.put("id_user", id_user);
        paramMap.put("keyword", key_save);
        paramMap.put("datenow", date_now);
        questionMapper.addQuestion(paramMap);
        long id_question = questionMapper.getQuestionId();
        return id_question;
    }

    @Override
    public boolean deleteQuestion(Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        boolean judge = questionMapper.deleteQuestion(paramMap);
        return judge;
    }
}
