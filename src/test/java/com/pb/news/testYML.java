package com.pb.news;

import com.pb.news.config.JedisConfig;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpParams;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class testYML {



    @Value("${redis.spring.redis.host}")
    private String host;

    @Test
    public void test(){
        //JedisConfig jedisConfig = new JedisConfig();
        System.out.println(host);
    }

    @Configuration
    @PropertySource("classpath:application.yml")
    static class PropertiesWithJavaConfig {


        @Bean
        public static PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

}
