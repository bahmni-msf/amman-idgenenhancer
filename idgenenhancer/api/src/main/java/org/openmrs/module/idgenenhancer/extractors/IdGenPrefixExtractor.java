package org.openmrs.module.idgenenhancer.extractors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;

/**
 * Created by vohray on 10/6/16.
 */
public class IdGenPrefixExtractor {
  protected final Log log = LogFactory.getLog(this.getClass());


  public String extractPrefixFromPatient(Patient patient)
  {
    String countryName=patient.getPersonAddress().getAddress3();
    String gender=patient.getGender();
    return countryName+gender;

  }
}
