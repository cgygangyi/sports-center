package com.gym1.util;
import com.gym1.util.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/venueState/**") // 拦截的请求 /service/**   表示拦截service下所有
                .excludePathPatterns("/user/login") // 不拦截的请求  如登录接口
                .excludePathPatterns("/venue/**"); // 不拦截的请求  如登录接口
    }
}
