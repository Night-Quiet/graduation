package cn.java.controller;

import cn.java.service.CommentService;
import cn.java.service.ReplyService;
import cn.java.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/13
 */
@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private CommentService commentService;
    @Autowired
    StatisticsService statisticsService;

    @RequestMapping(value = "/addReply.hml",method= RequestMethod.POST)
    public String addReply(Long id_comment, String reply, HttpSession session) {
        long questionId = Long.valueOf(session.getAttribute("questionId").toString());
        long userId = Long.valueOf(session.getAttribute("activeUserId").toString());
        String userName = session.getAttribute("activeUser").toString();
        String identify = session.getAttribute("activeIdentify").toString();
        boolean updateJudge = replyService.addReply(id_comment, identify, userId, userName, reply);

        List<Map<String, Object>> comment_show = commentService.getCommentById(questionId);
        for (int i=0; i<comment_show.size(); i++) {
            Long id_comment_one = Long.valueOf(comment_show.get(i).get("id_comment").toString());

            Map<String, Object> commentOne_update =  comment_show.get(i);
            commentOne_update.put("reply", replyService.getReplyById(id_comment_one));
            comment_show.set(i, commentOne_update);
        }

        session.setAttribute("comment", comment_show);

        statisticsService.updateIsReply(userId, questionId, 1);

        if (identify.equals("学生")) {
            return "sdetail";
        } else {
            return "tdetail";
        }
    }

    @RequestMapping(value = "/deleteReply.hml",method = RequestMethod.GET)
    public String deleteReply(Long id_reply, HttpSession session) {
        boolean judge = replyService.updateReply(id_reply, "回复与问题无关, 已被删除");

        long id_question = Long.valueOf(session.getAttribute("questionId").toString());
        List<Map<String, Object>> comment = commentService.getCommentById(id_question);
        for (int i=0; i<comment.size(); i++) {
            Long idComment = Long.valueOf(comment.get(i).get("id_comment").toString());

            Map<String, Object> commentOne_update =  comment.get(i);
            commentOne_update.put("reply", replyService.getReplyById(idComment));
            comment.set(i, commentOne_update);
        }
        session.setAttribute("comment", comment);
        return "tdetail";
    }
}
