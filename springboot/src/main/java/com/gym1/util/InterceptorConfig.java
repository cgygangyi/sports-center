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
                .addPathPatterns("/venueState/**") // Intercepted requests
                .addPathPatterns("/order/**") // Intercepted requests
                .addPathPatterns("/user/**") // Intercepted requests
                .excludePathPatterns("/user/login") // Requests not to be intercepted
                .excludePathPatterns("/user/register") // Requests not to be intercepted
                .excludePathPatterns("/venue/**"); // Requests not to be intercepted
    }
}
