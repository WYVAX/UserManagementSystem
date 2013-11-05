package com.peng.aop;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Component
@Aspect
public class LogInterceptor {
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}
	
	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Pointcut("execution(public * com.peng.service.*Service.*(..)) &&" +
			"@annotation(org.springframework.transaction.annotation.Transactional)")
	public void serviceMethod(){}
	
	@Pointcut("execution(public * com.peng.service.*Service.add(..))")
	public void addMethod(){}
	
	@Pointcut("execution(public * com.peng.service.*Service.delete(..))")
	public void delMethod(){}
	
	
	//@Around("addMethod() || delMethod()")
	@Around("serviceMethod()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("BEFORE Service: \" "+pjp.getSignature()+ " \" ");
		
		Object o = pjp.proceed();
	
		System.out.println("AFTER Service: \" "+pjp.getSignature() + " \" ");
		return o;
	}
}
