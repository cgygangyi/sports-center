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
                .addPathPatterns("/venueState/**")
                .addPathPatterns("/order/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/venue/**");
    }
}
