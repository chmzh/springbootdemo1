package com.example.demo;

import com.example.demo.cache.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {



	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisService service;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setId(1);
		user.setName("name11");
		user.setAge(19);
		service.addUser(user);

		logger.info("RedisTest执行完成，return {}",service.getStudent(user.getId()).getName());
	}
}
