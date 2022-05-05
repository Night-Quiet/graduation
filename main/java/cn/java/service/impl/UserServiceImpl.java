package cn.java.service.impl;


import cn.java.bean.User;
import cn.java.mapper.UserMapper;
import cn.java.service.UserService;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * author:宋琪
 * date: 02/06/2021
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean haveUser(String username, String password, Long id_identify, Long id_class) {
        boolean flag = true;
        if (flag) {
            Map<String, Object> paramMap = new HashMap<>();

            paramMap.put("username", username);
            paramMap.put("password", password);
            paramMap.put("id_class", id_class);
            paramMap.put("id_identify", id_identify);

            Map<String, Object> userMap = userMapper.haveUser(paramMap);
            int num = Integer.valueOf(userMap.get("num").toString());

            if (num <= 0) { flag = false; }
        }
        return flag;
    }

    @Override
    public boolean UserRegister(String username, String password, Long id_identify, Long id_class){
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("id_identify", id_identify);
        paramMap.put("id_class", id_class);

        boolean judge = userMapper.addUser(paramMap);

        return judge;
    }

    @Override
    public Map getUserByMulCondition(String username, String password, Long id_identify, Long id_class){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("id_class", id_class);
        paramMap.put("id_identify", id_identify);
        Map<String, Object> userMessage = userMapper.getUserByMulCondition(paramMap);
        return userMessage;
    }

    @Override
    public List<Map<String, Object>> getAllIdentify(Integer id_identify){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_identify", id_identify);
        List<Map<String, Object>> identifyList = userMapper.getAllIdentify(paramMap);
        return identifyList;
    }

}
