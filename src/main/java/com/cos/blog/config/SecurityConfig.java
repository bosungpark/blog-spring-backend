package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//빈등록: 스프링컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration
//Security 필터가 등록이 된다 = 스프링 시큐리티가 활성화 되고, 설정을 해당 파일에서 하겠다는 의미.
@EnableWebSecurity
//특정주소로 접근하면 권한 및 인증을 미리 체크
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
            .and()
//                인증이 필요할 때, 로그인 페이지로 이동
                .formLogin()
                .loginPage("/auth/loginForm");
    }
}
