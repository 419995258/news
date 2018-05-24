package com.pb.news;

import com.pb.news.annotation.RequestJsonHandlerMethodArgumentResolver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
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


	/**
	 * 跨域过滤器,解决ajax访问请求跨域
	 *
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addExposedHeader("x-auth-token");
		corsConfiguration.addExposedHeader("x-total-count");
		source.registerCorsConfiguration("/**", corsConfiguration); // 4
		return new CorsFilter(source);
	}




}
