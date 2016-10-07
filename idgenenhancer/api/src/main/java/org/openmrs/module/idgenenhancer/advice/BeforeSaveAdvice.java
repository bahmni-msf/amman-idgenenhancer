package org.openmrs.module.idgenenhancer.advice;

/**
 * Created by vohray on 10/7/16.
 */

import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.idgenenhancer.IdGenEnhancerService;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeSaveAdvice implements MethodBeforeAdvice {

  private static final String methodToIntercept = "savePatient";

  @Override
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    if(method.getName().equalsIgnoreCase(methodToIntercept))
    {
      Patient patient=(Patient)objects[0];
      PatientIdentifier identifier = patient.getPatientIdentifier();

      String patientIdentifier =identifier.getIdentifier().replaceAll("\\D+","");

      IdGenEnhancerService enhancer = new IdGenEnhancerService();
      String enhancedId=enhancer.enhanceGeneratedId(patient,patientIdentifier);
      identifier.setIdentifier(enhancedId);

    }

  }

  }
