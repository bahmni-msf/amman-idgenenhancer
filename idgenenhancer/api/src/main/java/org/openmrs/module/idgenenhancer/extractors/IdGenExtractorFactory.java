package org.openmrs.module.idgenenhancer.extractors;

/**
 * Created by vohray on 10/6/16.
 */
public class IdGenExtractorFactory {

  private static IdGenPrefixExtractor INSTANCE=new IdGenPrefixExtractor();

  public static IdGenPrefixExtractor getPrefixExtractor()
  {
    return INSTANCE;
  }
}
