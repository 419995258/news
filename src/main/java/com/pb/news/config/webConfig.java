package com.pb.news.config;


import com.pb.news.annotation.RequestJsonHandlerMethodArgumentResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@EnableWebMvc
@Configuration
public class webConfig extends WebMvcConfigurerAdapter {
    /*配置模板资源路径*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/");  //这个就全局了
        registry.addResourceHandler("/web/**").addResourceLocations("classpath:/web/"); //只有web路径会选择
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); //只有static路径会选择
        registry.addResourceHandler("/img/**").addResourceLocations("file:/D:/AllWorkspace/IDEA/mine/news/target/classes");  //本机图片路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }


    /*配置自定义接受参数的方法*/
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() throws Exception {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        //resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(1);
        resolver.setMaxUploadSize(50 * 1024 * 1024);//上传文件大小 50M 5*1024*1024
        resolver.setUploadTempDir(new FileSystemResource("/tmp/"));
        return resolver;
    }


    // 拦截器
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/userC/userLogin")
                .excludePathPatterns("/userC/validateUserLogin")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/web/base/login.html")
                .excludePathPatterns("/newsC/**");
    }

}