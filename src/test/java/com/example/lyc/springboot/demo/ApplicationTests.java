package com.example.lyc.springboot.demo;

import com.example.lyc.springboot.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
//@SpringBootTest
class ApplicationTests {
//	@Autowired
	@Test
	void UserTest() {
		User user=new User(1,"liyinchi","123456");
		// 日志输出
		log.info("user:{}",user);
		log.info("user:{}",user.toString());
		log.info("user:{}",user.getUserName());
		log.info("user:{}",user.getPassword());
		log.info("user:{}",user.getId());
	}

}
