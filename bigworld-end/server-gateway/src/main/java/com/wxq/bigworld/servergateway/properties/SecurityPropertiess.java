package com.wxq.bigworld.servergateway.properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * APP模块的统一配置
 */
@Component
//@Configurable
//@PropertySource("classpath:security.properties")
//@ConfigurationProperties(prefix = "com.wxq.security")
public class SecurityPropertiess {

    private JwtProperties jwt = new JwtProperties();

    public JwtProperties getJwt() {
        return jwt;
    }

    public void setJwt(JwtProperties jwt) {
        this.jwt = jwt;
    }

}
