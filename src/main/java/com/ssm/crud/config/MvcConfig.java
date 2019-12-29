package com.ssm.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Spring 5.0后，WebMvcConfigurerAdapter被废弃，取代的方法有两种：
 *
 * ①implements WebMvcConfigurer（官方推荐）
 *
 * ②extends WebMvcConfigurationSupport
 *
 * 使用第一种方法是实现了一个接口，可以任意实现里面的方法，不会影响到Spring Boot自身的@EnableAutoConfiguration，而使用第二种方法相当于覆盖了@EnableAutoConfiguration里的所有方法，每个方法都需要重写，比如，若不实现方法addResourceHandlers()，则会导致静态资源无法访问，实现的方法如下：
 *
 * @Override
 * protected void addResourceHandlers(ResourceHandlerRegistry registry) {
 *     registry.addResourceHandler("/**")
 *             .addResourceLocations("classpath:/META-INF/resources/")
 *             .addResourceLocations("classpath:/resources/")
 *             .addResourceLocations("classpath:/static/")
 *             .addResourceLocations("classpath:/public/");
 *     super.addResourceHandlers(registry);
 * }
 */
//@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

    //当浏览器发送/mi请求就来到success.html界面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
     //   registry.addViewController("/index.html").setViewName("login");
    //    registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("login");

    }

    //注册拦截器     之拦截controller中的有的请求，试图映射就失效啦
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/login.html","/hh");
        super.addInterceptors(registry);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/META-INF/resources/")
//                .addResourceLocations("classpath:/resources/")
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/public/");
//        super.addResourceHandlers(registry);
//    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("/static/");
//        super.addResourceHandlers(registry);
//    }

    //spring5后。官方不推荐使用
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurerAdapter(){
//        WebMvcConfigurationSupport adapter = new WebMvcConfigurationSupport(){
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//
//              //  registry.addViewController("/*").setViewName("once");
//            }
//        };
//        return adapter;
//    }

}
