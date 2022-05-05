package cn.java.service;

import cn.java.bean.User;

import java.util.List;
import java.util.Map;

//import org.springframework.stereotype.Service;

/**
 * description:
 * author: 黄金城
 * date: 02/16/2022
 */

//@Service
public interface UserService {
    public boolean haveUser(String username, String password, Long id_identify, Long id_class);

    public boolean UserRegister(String username, String password, Long id_identify, Long id_class);

    public Map getUserByMulCondition(String username, String password, Long id_identify, Long id_class);

    public List<Map<String, Object>> getAllIdentify(Integer id_identify);


}
