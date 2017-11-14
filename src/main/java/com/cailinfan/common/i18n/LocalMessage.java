package com.cailinfan.common.i18n;

import org.springframework.context.MessageSource;
import org.springframework.util.Assert;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 本地化消息类
 * Created by cailinfan on 2017/6/20.
 */
public class LocalMessage {
    private static MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        LocalMessage.messageSource = messageSource;
    }

    public static String getMessage(String code, Object[] args, HttpServletRequest request) {
        Assert.hasText(code, "消息码code不能为空");
        Assert.notNull(request, "HttpServletRequest对象不能为null");

        return messageSource.getMessage(code, args, RequestContextUtils.getLocale(request));
    }

    public static String getMessage(String code, HttpServletRequest request) {
        return messageSource.getMessage(code, null, RequestContextUtils.getLocale(request));
    }

    public static String getMessage(String code, Object[] args, Locale locale) {
        Assert.hasText(code, "消息码code不能为空");
        Assert.notNull(locale, "Locale对象不能为null");

        return messageSource.getMessage(code, args, locale);
    }

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }
}
