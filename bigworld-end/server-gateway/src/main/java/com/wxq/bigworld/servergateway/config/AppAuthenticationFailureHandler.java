package com.wxq.bigworld.servergateway.config;

import com.alibaba.fastjson.JSON;
import com.wxq.bigworld.servergateway.response.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义失败处理器
 */
public class AppAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败！");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()).data(null)));
    }
}
