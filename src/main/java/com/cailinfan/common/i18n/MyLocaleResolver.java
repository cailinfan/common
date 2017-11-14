package com.cailinfan.common.i18n;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by cailinfan on 2017/2/24.
 */
public class MyLocaleResolver implements LocaleResolver {
    private Locale locale;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        return locale != null ? locale : request.getLocale();
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        this.locale = (locale != null) ? locale : request.getLocale();
    }

    public Locale getLocale() {
        return this.locale;
    }
}
