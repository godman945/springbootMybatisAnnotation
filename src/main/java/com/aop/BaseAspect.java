package com.aop;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//第一次commit  
//@Aspect
//@Component 
public class BaseAspect {
	 @Pointcut("execution(public * com.api..*.*(..))*")
	 public void doBeforeController(){
		 
	 }
	 @Before("doBeforeController()")
	 public void doBefore(JoinPoint joinPoint) throws Throwable {
		 System.out.println(">>>>>>>>>doBefore");
		 
		 ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		 HttpServletRequest request = attributes.getRequest();

//		 Cookie[] cookieArray = request.getCookies();
//		 for (Cookie cookie : cookieArray) {
//			 System.out.println(cookie.getName());
//			 System.out.println(cookie.getValue());
//		 }
		 
		 //类名
         String clazzName = joinPoint.getTarget().getClass().getName();
         System.out.println(clazzName);
         
         
         MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
         
         
        
         //方法名
         String methodName = methodSignature.getName();
         
         
         System.out.println(methodName);
         
         //参数名数组
         String[] parameters =  methodSignature.getParameterNames();
         System.out.println(parameters);
         System.out.println(parameters[0]);
         //参数值
         Object[] args = joinPoint.getArgs();
         System.out.println(args);
         System.out.println(args[0]);

	 }
}

//public abstract class BaseAspect {
//	 protected Object process(ProceedingJoinPoint pjp, StringBuilder sb) throws Throwable {
//	        //獲取連線點目標類名
//	        String targetName = pjp.getTarget().getClass().getName();
//	        //獲取連線點簽名的方法名
//	        String methodName = pjp.getSignature().getName();
//	        //獲取連線點引數
//	        Object[] args = pjp.getArgs();
//	        //根據連線點類的名字獲取指定類
//	        Class targetClass = Class.forName(targetName);
//	        //獲取類裡面的方法
//	        Method[] methods = targetClass.getMethods();
//	        Object object = pjp.proceed();
////	        sb.append(targetClass.getCanonicalName())
////	                .append(methodName)
////	                .append(JSON.toJSONString(args))
////	                .append(object);
//	        return object;
//	    }
//}
