package com.cailinfan.common.web;

import com.cailinfan.common.Message;
import com.cailinfan.common.i18n.LocalMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Rest接口返回值工具类
 * Created by cailinfan on 2017/6/20.
 */
public abstract class ResponseEntityUtils {

    /**
     * 200
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * 构造Message对象
     * @param code
     * @param args
     * @param request
     * @return
     */
    private static Message buildErrorMessage(String code, Object[] args, HttpServletRequest request) {
        String msg = LocalMessage.getMessage(code, args, request);
        Message message = new Message(code, msg);
        return message;
    }

    /**
     * 404、500等常见错误
     * @param code
     * @param args
     * @param request
     * @param status
     * @return
     */
    public static ResponseEntity<Message> error(String code,
                                                Object[] args,
                                                HttpServletRequest request,
                                                HttpStatus status) {
        Assert.hasText(code, "消息码code不能为空");
        Assert.notNull(request, "HttpServletRequest对象不能为null");
        Assert.notNull(status, "HttpStatus对象不能为null");

        Message message = buildErrorMessage(code, args, request);
        return new ResponseEntity<>(message, status);
    }

    /**
     * 404、500等常见错误
     * @param code
     * @param request
     * @param status
     * @return
     */
    public static ResponseEntity<Message> error(String code,
                                                HttpServletRequest request,
                                                HttpStatus status) {
        return error(code, null, request, status);
    }

    /**
     * 数据验证错误
     * @param result
     * @param request
     * @return
     */
    public static ResponseEntity<Message> validationError(BindingResult result, HttpServletRequest request) {
        Assert.notNull(request, "HttpServletRequest对象不能为null");

        if (result == null || !result.hasErrors()) {
            throw new IllegalArgumentException("BindingResult为空或没有错误");
        }

        List<ObjectError> errorList = result.getAllErrors();

        Message message = buildErrorMessage(errorList.get(0).getDefaultMessage() , null, request);
        return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
    }
}
