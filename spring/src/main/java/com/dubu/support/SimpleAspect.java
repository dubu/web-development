package com.dubu.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * User: Administrator
 * Date: 13. 4. 2
 * Time: 오후 6:22
 */
@Aspect
public class SimpleAspect {
    long startTime;

    @Before("within(@org.springframework.stereotype.Controller *)")
    public void logBefore(JoinPoint joinPoint) {

        startTime = System.currentTimeMillis();
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    //@After("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
    @After("within(@org.springframework.stereotype.Controller *)")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("process time : " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("******");

    }

    /*
    @AfterReturning(
            //pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerReturnValue(..))"
            pointcut = "within(@org.springframework.stereotype.Controller *)"
            ,returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");


    }


    @AfterThrowing(
            //pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerThrowException(..))"
            pointcut = "within(@org.springframework.stereotype.Controller *)"
            ,throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {


        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }
    */

    /*
    //@Around("execution(* com.mkyong.customer.bo.CustomerBo.addCustomerAround(..))")
    @Around("within(@org.springframework.stereotype.Controller *)")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {


        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
    }
    */
}
