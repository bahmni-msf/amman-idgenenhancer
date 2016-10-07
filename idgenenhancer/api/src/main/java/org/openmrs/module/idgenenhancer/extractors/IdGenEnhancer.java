package org.openmrs.module.idgenenhancer.extractors;

import java.util.List;

/**
 * Created by vohray on 10/6/16.
 */
public class IdGenEnhancer {

  private String prefix="";
  private String suffix="";

  public void enhancePrefixess(List<String> prefixes)
  {
    StringBuilder builder= new StringBuilder();
    for(String prefix:prefixes)
    {
      builder.append(prefix);
    }
    prefix=prefix+ builder.toString();
  }

  public void enhanceSuffixes(List<String> suffixes)
  {
    StringBuilder builder= new StringBuilder();
    for(String suffix:suffixes)
    {
      builder.append(suffix);
    }
    suffix=suffix+ builder.toString();
  }

  public String enhanceId(String identifier)
  {
    StringBuilder builder=new StringBuilder();
    builder.append(prefix).append(identifier).append(suffix);
    return builder.toString();
  }


}
