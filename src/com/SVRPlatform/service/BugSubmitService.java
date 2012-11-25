package com.SVRPlatform.service;

import java.util.Map;

public interface BugSubmitService {

	public Map<String, String> bugSubmit(String graphAddress, String description,
										 String version, String softwareName, String bugDigest,
										 String email, int usabilityImpact, int dataImpact,
										 int privacyImpact, int availability, int frequency,
										 int score, String language);
}
