/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.idgenenhancer;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Patient;
import org.openmrs.module.idgenenhancer.extractors.IdGenEnhancer;
import org.openmrs.module.idgenenhancer.extractors.IdGenExtractorFactory;
import org.openmrs.module.idgenenhancer.extractors.IdGenPrefixExtractor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */

/**TODO
 * make this a service and fetch it from context
 */
public class IdGenEnhancerService extends BaseOpenmrsObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String enhanceGeneratedId(Patient patient, String identifier)
	{
		IdGenPrefixExtractor prefixExtractor= IdGenExtractorFactory.getPrefixExtractor();
		String extractedPrefix=prefixExtractor.extractPrefixFromPatient(patient);
		List<String>prefixes=new ArrayList<String>();
		prefixes.add(extractedPrefix);
		IdGenEnhancer idGenEnhancer=new IdGenEnhancer();
		idGenEnhancer.enhancePrefixess(prefixes);
		String enhancedID=idGenEnhancer.enhanceId(identifier);
		return enhancedID;

	}
	
}