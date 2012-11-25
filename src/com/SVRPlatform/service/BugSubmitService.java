package com.SVRPlatform.service;

import java.util.Map;

public interface BugSubmitService {

	public Map<String, String> bugSubmit(int level, String graphAddress, String description,
										 String version, String software, String bugDigest,
										 String user, int usabilityImpact, int dataImpact,
										 int privacyImpact, int availability, int frequency,
										 int score, String language, String bugNumber);
}
