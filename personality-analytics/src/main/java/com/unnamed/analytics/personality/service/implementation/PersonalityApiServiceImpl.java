package com.unnamed.analytics.personality.service.implementation;

import java.io.BufferedReader;
import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.unnamed.analytics.personality.facebook.reader.FacebookDataReader;
import com.unnamed.analytics.personality.services.PersonalityApiService;
import com.unnamed.analytics.personality.watson.api.WatsonPersonalityApi;

public class PersonalityApiServiceImpl implements PersonalityApiService {
	
	public String userPersonalityResult(String fbAccessToken) throws IOException {
		
		FacebookDataReader fbDataReader = new FacebookDataReader(fbAccessToken);
		String collectedData = fbDataReader.postsReader();
		String outputJson = null;
		String output = null;
		BufferedReader watsonOutput = null;
		
		JSONObject testJsonObject = new JSONObject();
		try {
			testJsonObject.put("collected_data", collectedData);
	        WatsonPersonalityApi watsonApi = new WatsonPersonalityApi("4aaae618-ffe8-4b3f-84da-ce4ccc37f430", "SIuk5Idc8nnB", "2016-10-20");
	        try {
			watsonOutput = watsonApi.uriBuilder(collectedData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while ((output = watsonOutput.readLine()) != null) {
           System.out.println("Final Output: " +output);
           outputJson = output;
        }
		System.out.println("Final Output 1: " +outputJson);
		return outputJson;
	}

}
