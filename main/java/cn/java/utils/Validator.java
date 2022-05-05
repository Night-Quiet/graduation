

package cn.java.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 数据校验工具类
 */
public class Validator {
    /**
     * Description:校验实体类中的属性是否正确
     * @return：如果返回值为null，则代表数据完全正确；如果不为null，则返回的是一个封装错误信息map集合
     */
    public static boolean fieldValidate(BindingResult errorResult) {
        Map<String, Object> errorMap = null;
        boolean flag = errorResult.hasErrors();
        if (flag) {// 数据有错
            errorMap = new HashMap<String, Object>();
            // 将字段对应的错误信息答应出来
            List<FieldError> errorList = errorResult.getFieldErrors();
            for (FieldError fieldError : errorList) {
                // 1、获取实体类中的属性名
                String fieldName = fieldError.getField();
                // 2、当数据不满足匹配规则时，获取错误提示信息
                String errorMessage = fieldError.getDefaultMessage();
                System.out.println(fieldName + "=" + errorMessage);
                errorMap.put(fieldName, errorMessage);
            }
        }
        if (errorMap == null) { return true; }
        else { return false; }
    }
}
