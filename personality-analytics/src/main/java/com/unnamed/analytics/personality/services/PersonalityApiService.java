package com.unnamed.analytics.personality.services;

import org.codehaus.jettison.json.JSONObject;

public interface PersonalityApiService {

	public JSONObject userPersonalityResult(String fbAccessToken);
}
