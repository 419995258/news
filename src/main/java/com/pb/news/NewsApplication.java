package com.pb.news;

import com.pb.news.annotation.RequestJsonHandlerMethodArgumentResolver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

@SpringBootApplication
@MapperScan("com.pb.news.dao") //搜索该目录下的mapper接口，与mapper接口的@Mapper二选一使用
public class NewsApplication {

	public static void main(String[] args) {

	    SpringApplication.run(NewsApplication.class, args);
	}


}
