package cn.java.controller;

import cn.java.service.DetailService;
import cn.java.service.QuestionService;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
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
 * author:
 * date: 2022/2/17
 */
@Controller
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private DetailService detailService;

    @RequestMapping(value = "/toLogout.hml",method = RequestMethod.GET)
    public String toLogout(HttpSession session) {
        session.removeAttribute("message");
        return "login";
    } /**可能需要清理数据**/

    @RequestMapping(value = "/toAsk.hml",method = RequestMethod.GET)
    public String toAsk() { return "ask"; }

    @RequestMapping(value = "/toAnswer.hml",method = RequestMethod.GET)
    public String toAnswer() { return "answer"; }

    @RequestMapping(value = "/toDetail.hml",method = RequestMethod.GET)
    public String toDetail() { return "tdetail"; }

    @RequestMapping(value = "/toMain.hml",method = RequestMethod.GET)
    public String toMain(HttpSession session) {
        long classId = Integer.parseInt(session.getAttribute("activeClassId").toString());
        List<Map<String, Object>> classQuestion = questionService.getQuestionByClass(classId);
        session.setAttribute("allQuestion", classQuestion);

        session.removeAttribute("question");
        session.removeAttribute("q_picPath");
        session.removeAttribute("answer");
        session.removeAttribute("a_picPath");
        session.removeAttribute("a_videoPath");

        return "qtable";
    }

    @RequestMapping(value = "/getClassQuestion.hml", method = RequestMethod.GET)
    public String getClassQuestion(HttpSession session) {
        long classId = Long.parseLong(session.getAttribute("activeClassId").toString());
        List<Map<String, Object>> classQuestion = questionService.getQuestionByClass(classId);

        session.removeAttribute("allQuestion");
        session.setAttribute("allQuestion", classQuestion);

        session.removeAttribute("question");
        session.removeAttribute("q_picPath");
        session.removeAttribute("answer");
        session.removeAttribute("a_picPath");
        session.removeAttribute("a_videoPath");

        return "qtable";
    }

    @RequestMapping(value = "/getMyQuestion.hml", method = RequestMethod.GET)
    public String getMyQuestion(HttpSession session) {
        long userId = Long.parseLong(session.getAttribute("activeUserId").toString());
        List<Map<String, Object>> myQuestion = questionService.getQuestionByUser(userId);

        session.removeAttribute("allQuestion");
        session.setAttribute("allQuestion", myQuestion);

        session.removeAttribute("question");
        session.removeAttribute("q_picPath");
        session.removeAttribute("answer");
        session.removeAttribute("a_picPath");
        session.removeAttribute("a_videoPath");
        return "qtable";
    }

    @RequestMapping(value = "/getNoAnswerQuestion.hml", method = RequestMethod.GET)
    public String getAnswerQuestion(HttpSession session){
        long classId = Long.parseLong(session.getAttribute("activeClassId").toString());
        List<Map<String, Object>> classQuestion = questionService.getQuestionByClass(classId);

        List<Map<String, Object>> noAnswer = new ArrayList<>();
        for (Map<String, Object> listOne: classQuestion) {
            long id_question = Long.valueOf(listOne.get("id_question").toString());
            if(detailService.whetherAnswer(id_question).equals("")){
                noAnswer.add(listOne);
            }
        }

        session.setAttribute("allQuestion", noAnswer);

        session.removeAttribute("question");
        session.removeAttribute("q_picPath");
        session.removeAttribute("answer");
        session.removeAttribute("a_picPath");
        session.removeAttribute("a_videoPath");

        return "qtable";
    }

    @RequestMapping(value = "/getSearchQuestion.hml", method = RequestMethod.POST)
    public String getSearchQuestion(String search, HttpSession session) {
        long classId = Long.parseLong(session.getAttribute("activeClassId").toString());
        List<Map<String, Object>> classQuestion = questionService.getQuestionByClass(classId);

        // 依靠文本推荐函数，将所有问题按摘要聚集，进行文本推荐
        Suggester suggester = new Suggester();
        for (Map<String, Object> questionOne: classQuestion) {
            String key = questionOne.get("keyword").toString();
            suggester.addSentence(key);
        }

        List<Term> termList = IndexTokenizer.segment(search);
        List<Map<String, Object>> recommend = new ArrayList<>();
        List<String> questionList = new ArrayList<>();
        for (Term term : termList) {
            List<String> questionSame = suggester.suggest(term.word, 2);
            for (String question: questionSame) {
                if (!questionList.contains(question)) {
                    Map<String, Object> questionFind = questionService.getQuestionBySummary(question).get(0);
                    recommend.add(questionFind);
                    questionList.add(question);
                }
            }
        }

        session.setAttribute("allQuestion", recommend);

        session.removeAttribute("question");
        session.removeAttribute("q_picPath");
        session.removeAttribute("answer");
        session.removeAttribute("a_picPath");
        session.removeAttribute("a_videoPath");

        return "qtable";
    }

    @RequestMapping(value = "/getAnswer.hml", method = RequestMethod.POST)
    public String getAnswer(int select, String question, MultipartRequest files, HttpSession session, HttpServletRequest request) throws Exception{
        if(select == 1){ /**推荐答案**/
            long classId = Integer.parseInt(session.getAttribute("activeClassId").toString());
            List<Map<String, Object>> allQuestion = questionService.getQuestionByClass(classId);
            // 依靠文本推荐函数，将所有问题按摘要聚集，进行文本推荐
            Suggester suggester = new Suggester();
            for (Map<String, Object> questionOne: allQuestion) {
                String key = questionOne.get("keyword").toString();
                suggester.addSentence(key);
            }
            String summary = HanLP.extractSummary(question, 1).get(0);
            String questionSame = suggester.suggest(summary, 1).get(0);

            long questionFind_id = Long.valueOf(questionService.getQuestionBySummary(questionSame).get(0).get("id_question").toString());
            Map<String, Object> answer = detailService.getDetailById(questionFind_id);
            String return_answer = answer.get("answer").toString();

            if(return_answer.equals("")) {
                session.setAttribute("answer", "暂无相似问题回答");
            }else {
                session.setAttribute("answer", return_answer);
            }
            List<String> a_picPath = new ArrayList<>();
            List<String> a_videoPath = new ArrayList<>();
            for (int i=1; i<4; i++) {
                if(!answer.get("a_pic"+String.valueOf(i)).toString().equals("")) {
                    a_picPath.add(answer.get("a_pic"+String.valueOf(i)).toString());
                }
            }
            if(!answer.get("a_video").toString().equals("")) {
                a_videoPath.add(answer.get("a_video").toString());
            }
            session.setAttribute("a_picPath", a_picPath);
            session.setAttribute("a_videoPath", a_videoPath);
            return "ask";
        }else if(select == 2){ /**上传问题**/
            long userId = Integer.parseInt(session.getAttribute("activeUserId").toString());
            long classId = Integer.parseInt(session.getAttribute("activeClassId").toString());

            long id_question = questionService.addQuestion(classId, userId, question);

            List<String> filePath = getFilePath(files, request);
            boolean addJudge = detailService.addDetail(id_question, question, "", filePath.get(0), filePath.get(1), filePath.get(2), "", "", "", "");
            return "ask";
        }else {
            return "qtable";
        }
    }

    @RequestMapping(value = "deleteQuestion.hml", method = RequestMethod.GET)
    public String deleteQuestion(HttpSession session) {
        long id_question = Long.valueOf(session.getAttribute("questionId").toString());
        boolean judge = questionService.deleteQuestion(id_question);

        long classId = Long.parseLong(session.getAttribute("activeClassId").toString());
        List<Map<String, Object>> classQuestion = questionService.getQuestionByClass(classId);

        session.removeAttribute("allQuestion");
        session.setAttribute("allQuestion", classQuestion);
        return "qtable";
    }

}
