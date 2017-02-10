package com.unnamed.analytics.personality.service.implementation;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.unnamed.analytics.personality.facebook.reader.FacebookDataReader;
import com.unnamed.analytics.personality.services.PersonalityApiService;

public class PersonalityApiServiceImpl implements PersonalityApiService {
	
	public JSONObject userPersonalityResult(String fbAccessToken) {
		
		FacebookDataReader fbDataReader = new FacebookDataReader(fbAccessToken);
		String collectedData = fbDataReader.postsReader();
		
		JSONObject testJsonObject = new JSONObject();
		try {
			testJsonObject.put("collected_data", collectedData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testJsonObject;
	}

}
