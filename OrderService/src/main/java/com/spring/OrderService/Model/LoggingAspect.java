package com.spring.OrderService.Model;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
@AfterThrowing(pointcut="execution(* com.spring.OrderService.Model.ProductServiceClient.*(..))", throwing = "exception")
public void logFailedProductServiceCall(Exception exception)
{
	System.err.println("Failed call to Product Service :"+exception.getMessage());
}
}
