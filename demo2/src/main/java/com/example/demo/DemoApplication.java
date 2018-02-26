package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {


	@Override
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(DemoApplication.class);
	}
	@Autowired
	private PersonDao dao;



	@RequestMapping("/json")
	public Map<String,String> json(){
		Map<String,String> map = new HashMap<>();
		map.put("a","a");
		map.put("b","b");
		return map;
	}

	@RequestMapping("/get")
	@Transactional
	public City getP(long id){
//        City city = new City();
//        city.setName("abc");
//        city.setProvince("abc");
//        dao.save(city);
//        City person = dao.findByName(name).get(0);
		int i = dao.updateName("你好",2);
		//dao.deleteCity(2L);
		City person = dao.getCity(id);
		return person;
	}
	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot";
	}

}
