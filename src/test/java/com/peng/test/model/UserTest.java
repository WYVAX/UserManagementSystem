package com.peng.test.model;

import javax.annotation.Resource;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.peng.model.*;
import com.peng.service.UserService;

public class UserTest {

	private static ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/test/java/applicationContext.xml");
	private UserService userService = (UserService)ctx.getBean("userService");
	private LocalSessionFactoryBean sf = (LocalSessionFactoryBean) ctx.getBean("&sf");
	

	public LocalSessionFactoryBean getSf() {
		return sf;
	}
	
	@Resource
	public void setSf(LocalSessionFactoryBean sf) {
		this.sf = sf;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@AfterClass
	public static void afterClass(){
		//ctx.destroy();
	}
	
	@Test
	public void schemaTest(){
		new SchemaExport(sf.getConfiguration()).create(true, true);

	}
	
	@Test
	public void userAddTest() throws Exception{
		User user = new User();
		Address addr = new Address();
		addr.setCountry("US");
		addr.setRoomNumber(14);
		addr.setState("MI");
		addr.setStreetAddr("5000 S Hagadorn rd.");
		user.addAddress(addr);
		user.setFirstName("Peng");
		user.setLastName("Zang");
		user.setPassword("asdf");
		userService.add(user);
	}
	
	@Test
	public void userDelTest() throws Exception{
		userAddTest();
		userAddTest();
		User user = userService.getFirst();
		while(user != null){
		
		System.out.println(user+" ");
		
		
		System.out.println(" "+userService.exists(user));
		
		userService.delete(user);
		user=userService.getFirst();
		}
	}
}
