package cn.java.controller;

import cn.java.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author: YeShenRen
 * date: 2022/3/14
 */
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/show.hml",method= RequestMethod.GET)
    public String show(HttpSession session, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<>();

        List<List> studentView = new ArrayList<>();
        List<String> studentNameList = new ArrayList<>();
        List<Integer> studentViewNumList = new ArrayList<>();

        List<Map<String, Object>> studentAsk = new ArrayList<>();

        List<List> studentComment = new ArrayList<>();
        List<Integer> studentCommentNumList = new ArrayList<>();

        List<Map<String, Object>> studentReply = new ArrayList<>();

        List<Map<String, Object>> studentList = userService.getAllIdentify(0);
        for (Map<String, Object> student: studentList) {
            Long studentId = Long.valueOf(student.get("id_user").toString());
            String studentName = student.get("username").toString();
            int studentViewNum = statisticsService.getStatisticsByUser(studentId).size();

            studentNameList.add(studentName);
            studentViewNumList.add(studentViewNum);

            int studentAskNum = questionService.getQuestionByUser(studentId).size();
            Map<String, Object> temp = new HashMap<>();
            temp.put("value", studentAskNum);
            temp.put("name", studentName);
            studentAsk.add(temp);

            int studentCommentNum = commentService.getCommentByUser(studentId).size();
            studentCommentNumList.add(studentCommentNum);

            int studentReplyNum = replyService.getReplyByUser(studentId).size();
            Map<String, Object> temp2 = new HashMap<>();
            temp2.put("value", studentReplyNum);
            temp2.put("name", studentName);
            studentReply.add(temp2);
        }
        studentView.add(studentNameList);
        studentView.add(studentViewNumList);

        studentComment.add(studentNameList);
        studentComment.add(studentCommentNumList);

        map.put("studentView", studentView);
        map.put("studentAsk", studentAsk);
        map.put("studentComment", studentComment);
        map.put("studentReply", studentReply);

        JSONObject jsonObj = new JSONObject(map);

        String basePath = request.getServletContext().getRealPath("/file");
        File dirs=new File(basePath);
        if (!dirs.exists()) {
            dirs.mkdirs();
        }
        File f = new File(dirs, "data.txt");
        System.out.println(f.getAbsolutePath());
        PrintWriter output = new PrintWriter(f);
        output.print(jsonObj);
        output.close();
        return "statistics";
    }
}
