package com.benny.practice.calendaractivities.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

//    @Autowired
//    private UserDetailServiceImpl userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                //public paths
                .antMatchers("/error", "/api/user/**", "/api/event/**").permitAll()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                //Authenticate remaining paths
                .anyRequest().fullyAuthenticated()
                //login form and path
                .and().formLogin().loginPage("/api/user/login").and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout", "POST"))
                //Enable Basic Auth
                .and().httpBasic().and()
                //STATELESS so no session is created or used
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //Cross-site-request-forgery
                .csrf().disable();
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
