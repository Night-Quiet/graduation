package cn.java.controller;

import cn.java.service.CommentService;
import cn.java.service.DetailService;
import cn.java.service.ReplyService;
import cn.java.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static cn.java.utils.FileSave.getFilePath;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/9
 */
@Controller
@RequestMapping(value = "/detail")
public class DetailController {
    @Autowired
    private DetailService detailService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    StatisticsService statisticsService;

    @RequestMapping(value = "/questionDetail.hml",method= RequestMethod.GET)
    public String detail(String questionid, HttpSession session) {
        /** 获取 跳转 至指定问题的问题详情 **/
        long id_question = Long.parseLong(questionid);
        Map<String, Object> detail = detailService.getDetailById(id_question);

        List<String> q_picPath = new ArrayList<>();
        List<String> a_picPath = new ArrayList<>();
        List<String> a_videoPath = new ArrayList<>();

        for (int i=1; i<4; i++) {
            String q_picPath_one = detail.get("q_pic"+String.valueOf(i)).toString();
            String a_picPath_one = detail.get("a_pic"+String.valueOf(i)).toString();

            if (!q_picPath_one.equals("")) { q_picPath.add(q_picPath_one); }
            if (!a_picPath_one.equals("")) { a_picPath.add(a_picPath_one); }
        }
        a_videoPath.add(detail.get("a_video").toString());

        session.setAttribute("question", detail.get("question").toString());
        session.setAttribute("answer", detail.get("answer").toString());
        session.setAttribute("q_picPath", q_picPath);
        session.setAttribute("a_picPath", a_picPath);
        session.setAttribute("a_videoPath", a_videoPath);
        session.setAttribute("questionId", questionid);

        String identify = session.getAttribute("activeIdentify").toString();
        int identifyId = Integer.valueOf(session.getAttribute("activeIdentifyId").toString());
        List<Map<String, Object>> comment = commentService.getCommentById(id_question);
        for (int i=0; i<comment.size(); i++) {
            Long id_comment = Long.valueOf(comment.get(i).get("id_comment").toString());

            Map<String, Object> commentOne_update =  comment.get(i);
            commentOne_update.put("reply", replyService.getReplyById(id_comment));
            comment.set(i, commentOne_update);
        }
        session.setAttribute("comment", comment);

        Long userId = Long.valueOf(session.getAttribute("activeUserId").toString());
        if (!statisticsService.haveView(userId, id_question)) {
            statisticsService.addStatistics(userId, id_question, identifyId);
        }

        if (identify.equals("学生")) {
            return "sdetail";
        } else {
            return "tdetail";
        }
    }

    /*文件需区分照片 视频*/
    @RequestMapping(value = "/answerQuestion.hml", method = RequestMethod.POST)
    public String answerQuestion(String answer, MultipartRequest files, HttpSession session, HttpServletRequest request) throws Exception{
        long id_question = Long.valueOf(session.getAttribute("questionId").toString());
        List<String> filePath = getFilePath(files, request);
        boolean updateJudge = detailService.updateDetail(id_question, answer, filePath.get(0), filePath.get(1), filePath.get(2), filePath.get(3));
        session.setAttribute("answer", answer);
        List<String> a_picPath = new ArrayList<>();
        List<String> a_videoPath = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (!filePath.get(i).equals("")) {
                a_picPath.add(filePath.get(i));
            }
        }
        a_videoPath.add(filePath.get(3));

        session.setAttribute("a_picPath", a_picPath);
        session.setAttribute("a_videoPath", a_videoPath);
        return "tdetail";
    }
}
