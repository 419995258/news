package com.pb.news;

import com.pb.news.services.vo.RedisService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApplicationTests {

    @Autowired
    private RedisService redisService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getRedis(){
        System.out.println(redisService.get("test"));
    }

    @Test
    public void setRedis(){
        redisService.set("test","32132132132132");
    }

}
