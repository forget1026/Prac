package com.example.demo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO Auto-generated method stub
        registry.addMapping("/**") //모든 요청에 대해서
        .allowedOrigins("http://localhost:8081")
        .allowedMethods(
            HttpMethod.GET.name(),
            HttpMethod.HEAD.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name()
        );
         //허용할 오리진들
    }

}
// 참고문헌 : https://siyoon210.tistory.com/154
// 참고문헌2: https://velog.io/@hellozin/Spring-API-%EC%84%9C%EB%B2%84%EC%97%90%EC%84%9C-PUT-DELETE-%EC%9A%94%EC%B2%AD-%EC%8B%9C-CORS-%EC%84%A4%EC%A0%95%EC%9D%B4-%EC%A0%81%EC%9A%A9-%EC%95%88%EB%90%98%EB%8A%94-%EA%B2%BD%EC%9A%B0