/**
 * Project Name:dt48_springMVC4
 * File Name:UserValidator.java
 * Package Name:cn.java.entity
 * Date:下午2:47:38
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
*/

package cn.java.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class UserValidator {
    @NotNull(message = "亲，您没有填写昵称")
    @Pattern(regexp = "[\\u4e00-\\u9fa5]{4,10}", message = "*昵称必须为4-10位汉字")
    private String nick;// 昵称
    @Pattern(regexp = "\\w{3,6}", message = "*密码必须为3-6位字母、数字或者下划线组合")
    private String password;// 密码
    @Length(max = 11, min = 11, message = "手机号的长度必须是11位.")
    private String phone;// 手机号
    @Email(message = "对不起，您输入的邮箱格式有误")
    private String email;// 邮箱
    @Min(value = 1, message = "年龄太小啦")
    @Max(value = 150, message = "年龄太大啦")
    private Integer age;// 年龄(1-150)

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserValidator [nick=" + nick + ", password=" + password + ", phone=" + phone + ", email=" + email + ", age=" + age
                + "]";
    }

}
