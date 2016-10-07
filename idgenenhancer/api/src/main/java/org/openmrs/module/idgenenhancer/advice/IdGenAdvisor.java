package org.openmrs.module.idgenenhancer.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by vohray on 10/7/16.
 */
public class IdGenAdvisor extends StaticMethodMatcherPointcutAdvisor implements Advisor {
  private static final String CREATE_METHOD = "create";
  private static final String JOINEDCLASS="BahmniPatientProfileResource";
  private static final Advice advice=new BeforeSaveAdvice();

  public IdGenAdvisor() {
    super(advice);
  }

  @Override
  public boolean matches(Method method, Class<?> aClass) {
    return CREATE_METHOD.equals(method.getName())||method.getName().contains("update");
  }


}

