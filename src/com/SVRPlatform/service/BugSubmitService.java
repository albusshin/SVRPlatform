package com.SVRPlatform.service;

import java.util.Map;

public interface BugSubmitService {

	public Map<String, String> bugSubmit(String graphAddress, String description,
										 String version, String softwareName, String bugDigest,
										 String email, String usabilityImpact, String dataImpact,
										 String privacyImpact, String availability, 
										 String frequency, String language);
}
