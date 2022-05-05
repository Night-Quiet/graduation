package cn.java.service.impl;

import cn.java.mapper.DetailMapper;
import cn.java.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/9
 */
@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailMapper detailMapper;

    /** 根据问题Id获取问题全部信息 **/
    @Override
    public Map<String, Object> getDetailById(Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        Map<String, Object> detail = detailMapper.getDetailById(paramMap);
        return detail;
    }

    /** 添加问题信息 **/
    @Override
    public boolean addDetail(Long id_question, String question, String answer, String q_pic1, String q_pic2, String q_pic3, String a_pic1, String a_pic2, String a_pic3, String a_video) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        paramMap.put("question", question);
        paramMap.put("answer", answer);
        paramMap.put("q_pic1", q_pic1);
        paramMap.put("q_pic2", q_pic2);
        paramMap.put("q_pic3", q_pic3);
        paramMap.put("a_pic1", a_pic1);
        paramMap.put("a_pic2", a_pic2);
        paramMap.put("a_pic3", a_pic3);
        paramMap.put("a_video", a_video);
        boolean judge = detailMapper.addDetail(paramMap);
        return judge;
    }

    /** 根据问题Id获取问题答案 **/
    @Override
    public String whetherAnswer(Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        Map<String, Object> detail = detailMapper.getDetailById(paramMap);
        String answer = detail.get("answer").toString();
        return answer;
    }

    /** 更新问题答案 **/
    @Override
    public boolean updateDetail(Long id_question, String answer, String a_pic1, String a_pic2, String a_pic3, String a_video) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        paramMap.put("answer", answer);
        paramMap.put("a_pic1", a_pic1);
        paramMap.put("a_pic2", a_pic2);
        paramMap.put("a_pic3", a_pic3);
        paramMap.put("a_video", a_video);
        boolean judge = detailMapper.updateDetail(paramMap);
        return judge;
    }
}
