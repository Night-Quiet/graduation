package cn.java.mapper;

import java.util.List;
import java.util.Map;

/**
 * decription:
 * author: 单键
 * date: 2021/6/9
 */
public interface UserMapper {

    // 判断是否有这个用户
    public Map<String, Object> haveUser(Map<String, Object> map);

    // 添加用户
    public boolean addUser(Map<String, Object> map);

    // 通过 账号 密码 班级Id 查询用户信息
    public Map<String, Object> getUserByMulCondition(Map<String, Object> map);

    // 查询所有的学生 | 教师
    public List<Map<String, Object>> getAllIdentify(Map<String, Object> map);

}
