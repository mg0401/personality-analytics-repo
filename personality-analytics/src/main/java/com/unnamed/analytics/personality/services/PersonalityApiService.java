package com.unnamed.analytics.personality.services;

import org.codehaus.jettison.json.JSONObject;

public interface PersonalityApiService {

	public String userPersonalityResult(String fbAccessToken) throws Exception;
}
