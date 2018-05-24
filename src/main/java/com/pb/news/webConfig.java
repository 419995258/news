package com.pb.news;


import com.pb.news.annotation.RequestJsonHandlerMethodArgumentResolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class webConfig extends WebMvcConfigurerAdapter {
    /*配置模板资源路径*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/");  //这个就全局了
        registry.addResourceHandler("/web/**").addResourceLocations("classpath:/web/"); //只有web路径会选择
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); //只有static路径会选择
        registry.addResourceHandler("/img/**").addResourceLocations("file:/G:/AllWorkspace/IDEA/mine/news/target/classes");  //本机图片路径
    }


    /*配置自定义接受参数的方法*/
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
    }

}