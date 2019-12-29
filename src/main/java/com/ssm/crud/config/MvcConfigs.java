package com.ssm.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 拦截器最终实现------------->>>>终极版
 */
@Configuration
public class MvcConfigs implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截已加载");
    //    registry.addInterceptor(new  LoginHandlerIntercepter()).addPathPatterns("/**")
     //           .excludePathPatterns("/","/index.html","/hh","/selectid/*");
//        InterceptorRegistration addInterceptor = registry.addInterceptor(new LoginHandlerIntercepter());
//        //排除配置
//        addInterceptor.excludePathPatterns("/","/index.html");
//        //拦截配置
//        addInterceptor.addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/main.html").setViewName("index");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/META-INF/resources/")
//                .addResourceLocations("classpath:/resources/")
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/public/");
//
//    }

}
