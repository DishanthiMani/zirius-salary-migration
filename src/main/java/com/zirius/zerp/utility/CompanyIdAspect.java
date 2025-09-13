package com.zirius.zerp.utility;


import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CompanyIdAspect {

    @Autowired
    private EntityManager entityManager;

    //any method inside repositories
    @Before("execution(* com.zirius.zerp.repository..*(..))")
    public void applyCompanyIdBeforeRepoMethods() {
        CompanyIdUtil.applyCompanyId(entityManager);
    }
}
