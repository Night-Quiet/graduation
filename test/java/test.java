import cn.java.bean.User;
import java.io.*;

import cn.java.mapper.*;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.OBJ_ADAPTER;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;

import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import info.debatty.java.stringsimilarity.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * description:
 * author:
 * date: 2022/2/17
 */
public class test {
    ClassPathXmlApplicationContext context;
    UserMapper userMapper;
    QuestionMapper questionMapper;
    StatisticsMapper statisticsMapper;
    CommentMapper commentMapper;
    ReplyMapper replyMapper;
    DetailMapper detailMapper;

    @Before
    public void init(){
        context= new ClassPathXmlApplicationContext("applicationContext.xml");
        userMapper = (UserMapper) context.getBean("userMapper");
        questionMapper = (QuestionMapper) context.getBean("questionMapper");
        statisticsMapper = (StatisticsMapper) context.getBean("statisticsMapper");
        commentMapper = (CommentMapper) context.getBean("commentMapper");
        replyMapper = (ReplyMapper) context.getBean("replyMapper");
        detailMapper = (DetailMapper) context.getBean("detailMapper");
//        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testPlay() throws Exception{
        // 获取当前日期：年-月-日 时：分：秒：毫秒
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time1 = timestamp.toString();
        String time_need = time1.substring(0, time1.indexOf(" "));
        System.out.println("获取当前时间格式日期："+time1);
        System.out.println("日期" + time_need);

        // 时间-->时间戳
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf1.parse(time1);
        long time = date1.getTime();
        String res1 = String.valueOf(time);
        System.out.println("当前时间时间戳" + res1);

        // 时间戳-->时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        long lt = new Long(res1);
        Date date2 = new Date(lt);
        String res2 = sdf2.format(date2);
        String[] str_list = res2.split("-");
        System.out.println(res2);
    }
    @Test
    public void test() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("第一个内容", "第一个答案");
        map.put("第二个内容", "第二个答案");
        map.put("第三个内容", "第三个答案");
        JSONObject jsonObj = new JSONObject(map);
        System.out.println(jsonObj);

        String jsonStr = "{\"code\":\"0\",\"data\":{\"name\":\"Jackson\",\"age\":6},\"data1\":[{\"name\":\"Lee\",\"age\":18},{\"name\":\"Jack\",\"age\":20}]}";
        JSONObject jsonObject = new JSONObject(jsonStr);
        System.out.println(jsonObject);
        Set<String> keySet = jsonObject.keySet();

        String key = "";
        Object value = null;
        Map<String, Object> data = new HashMap<>();
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
            key = iterator.next();
            value = jsonObject.get(key);
            data.put(key, value);
        }
        System.out.println(data);
    }

    @Test
    public void fileTest() throws Exception {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map.put("第一个内容", "第一个答案");
        map.put("第二个内容", "第二个答案");
        map.put("第三个内容", "第三个答案");
        map1.put("第一个内容", "第一个答案");
        map1.put("第二个内容", "第二个答案");
        map1.put("第三个内容", "第三个答案");


        List list_save = new ArrayList();
        List list = new ArrayList();
        list.add("衬衫");
        list.add("裤子");
        list_save.add(list);
        map.put("list", list_save);
        map.put("map", map1);
        System.out.println(map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);


        File f1=new File(".\\src\\test\\fileSave\\aa.txt");//相对路径，如果没有前面的src，就在当前目录创建文件
        PrintWriter output = new PrintWriter(f1);
        output.print(jsonObject);
        output.close();
    }

    @Test
    public void sta() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_identify", 0);
        List<Map<String, Object>> identifyList = userMapper.getAllIdentify(paramMap);
        System.out.println(identifyList);
        for (Map<String, Object> student: identifyList) {
            Long id_user = Long.valueOf(student.get("id_user").toString());
            System.out.println(id_user);
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("id_user", id_user);
            List<Map<String, Object>> userView = statisticsMapper.getStatisticsByUser(paramMap1);
            System.out.println(userView.size());
        }
    }

    @Test
    public void test1() {
        boolean flag = true;
        if (flag) {
            Map<String, Object> paramMap = new HashMap<>();

            paramMap.put("username", "student");
            paramMap.put("password", "1234");
            paramMap.put("id_class", "1");
            paramMap.put("id_identify", "0");

            Map<String, Object> userMap = userMapper.haveUser(paramMap);
            int num = Integer.valueOf(userMap.get("num").toString());

            if (num <= 0) { flag = false; }
        }
        System.out.println(flag);
    }

    public List<Map<String, Object>> getQuestionByClass(int id_class){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_class", id_class);
        List<Map<String, Object>> classQuestion = questionMapper.getQuestionByClass(paramMap);
        return classQuestion;
    }

    public List<Map<String, Object>> getQuestionBySummary(String key){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", key);
        List<Map<String, Object>> summaryQuestion = questionMapper.getQuestionBySummary(paramMap);
        return summaryQuestion;
    }

    public Map<String, Object> getDetailById(Long id_question) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_question", id_question);
        Map<String, Object> detail = detailMapper.getDetailById(paramMap);
        return detail;
    }

    @Test
    public void one(){
        int id_class=1;
        String question="我是好人";
        List<Map<String, Object>> allQuestion = getQuestionByClass(id_class);
        // 依靠文本推荐函数，将所有问题按摘要聚集，进行文本推荐
        Suggester suggester = new Suggester();
        for (Map<String, Object> questionOne: allQuestion) {
            String key = questionOne.get("keyword").toString();
            System.out.println(key);
            suggester.addSentence(key);
        }
        String summary = HanLP.extractSummary(question, 1).get(0);
        String questionSame = suggester.suggest(summary, 1).get(0);

        long questionFind_id = Long.valueOf(getQuestionBySummary(questionSame).get(0).get("id_question").toString());
        Map<String, Object> answer = getDetailById(questionFind_id);
        String return_answer = answer.get("answer").toString();

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
    }


}
