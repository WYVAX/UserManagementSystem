package com.peng.test.model;

import java.util.Set;

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
	private static int index=0;

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
		SchemaExport se = new SchemaExport(sf.getConfiguration());
		se.setFormat(true).setOutputFile("schema.sql");
		se.create(true, true);

	}
	
	@Test
	public void exportDevSchema(){
		ApplicationContext ctx2 = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/applicationContext.xml");
		LocalSessionFactoryBean sf2 = (LocalSessionFactoryBean) ctx2.getBean("&sf");
		new SchemaExport(sf2.getConfiguration()).create(true, true);
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
		user.setUsername("pzang" + index++);
		user.setFirstName("Peng");
		user.setLastName("Zang");
		user.setPassword("asdf");
		userService.add(user);
	}
	
	@Test
	public void userDelTest() throws Exception{
		schemaTest();
		userAddTest();
		userAddTest();
		User user = userService.getFirst();
		while(user != null){
		
		System.out.println(user+" ");
		
		
		System.out.println(" "+userService.exists(user));
		
		userService.delete(user.getUsername());
		user=userService.getFirst();
		}
	}
	
	@Test
	public void getAllTest() throws Exception{
		schemaTest();
		userAddTest();
		userAddTest();
		
		Set<User> users= userService.getAll();
		for(User u : users){
			System.out.println(u);
		}
	}
}
