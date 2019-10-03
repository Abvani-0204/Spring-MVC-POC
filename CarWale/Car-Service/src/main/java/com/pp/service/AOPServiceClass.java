package com.pp.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPServiceClass {

	Long after, before;

	@Before("execution(* com.pp.service.WebSrvService.getAllValuesFromWebServiceModel(..))")
	public void beforeForGetRecordById() {
		before = System.currentTimeMillis();
		System.out.println(" AOP TIME BEFORE METHOD CALLED: " + before);
	}

	@After("execution(* com.pp.service.WebSrvService.getAllValuesFromWebServiceModel(..))")
	public void afterForGetRecordById() {
		after = System.currentTimeMillis();
		System.out.println("AOP TIME AFTER METHOD CALLED: " + (after - before));

	}
}
