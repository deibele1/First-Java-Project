package dev.deathstarreactorcore.aspects;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dev.deathstarreactorcore.services.UserService;


@Aspect
@Component
public class Authentication {
    @Autowired
    UserService us;

    @Around("authMethod()")
    public Object checkAuthentication(ProceedingJoinPoint jpt) throws Throwable{

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        if(us.authenticate(request.getHeader("username"),request.getHeader("password"))) {
            return jpt.proceed();
        }
        response.sendError(401);
        return null;
    }


    @Pointcut("@annotation(dev.deathstarreactorcore.annotations.AuthenticatedUser)")
    public void authMethod() {

    }
}