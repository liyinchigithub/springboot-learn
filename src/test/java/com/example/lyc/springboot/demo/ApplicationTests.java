package com.example.lyc.springboot.demo;

import com.example.lyc.springboot.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
//@SpringBootTest
class ApplicationTests {
//	@Autowired
	public
	@Test
	void contextLoads() {
		User  user=new User(1,"liyinchi","123456");
		// 调试输出
		System.out.println(user.getUsername());
	}

}
