package com.library.management;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Srinu on 07/12/20.
 */
@Component
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);

    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        if (logger.isDebugEnabled()) {
            logger.debug("[" + handler + "] startTime : " + startTime + "ms");
        }
        return true;
    }

    //after the handler is executed
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {

        long startTime = (Long) request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;

        //modified the exisitng modelAndView

        //log it
        if (logger.isDebugEnabled()) {
            logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
        }
    }
}
