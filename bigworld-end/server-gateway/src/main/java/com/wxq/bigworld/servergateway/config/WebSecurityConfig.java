package com.wxq.bigworld.servergateway.config;


import com.wxq.bigworld.servergateway.filter.CodeUsernamePasswordAuthenticationFilter;
import com.wxq.bigworld.servergateway.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 暂未考虑csrf
        http.authorizeRequests().antMatchers("/").permitAll()
                .and().formLogin().loginProcessingUrl("/login").permitAll()
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and().logout().logoutSuccessHandler(logoutSuccessHandler()).permitAll()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AppAuthenticationFailureHandler();
    }


    @Bean
    public CodeUsernamePasswordAuthenticationFilter codeUsernamePasswordAuthenticationFilter() throws Exception {
        CodeUsernamePasswordAuthenticationFilter codeUsernamePasswordAuthenticationFilter = new CodeUsernamePasswordAuthenticationFilter();
        codeUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        codeUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        codeUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        return codeUsernamePasswordAuthenticationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BigworldLogoutSuccessHandler logoutSuccessHandler() throws Exception {
        return new BigworldLogoutSuccessHandler();
    }


}
