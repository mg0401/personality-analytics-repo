package com.unnamed.analytics.personality.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONObject;

import com.unnamed.analytics.personality.constants.PersonalityConstants;
import com.unnamed.analytics.personality.service.implementation.PersonalityApiServiceImpl;
import com.unnamed.analytics.personality.services.PersonalityApiService;

@Path("/personality/")
public class PersonalityApiServiceController {
	
	private PersonalityApiService personalityApiService = new PersonalityApiServiceImpl();
	
	@GET
	@Path("/result")
	public String getUserPersonalityResult(@QueryParam(PersonalityConstants.FB_ACCESS_TOKEN) String fbAccessToken) throws Exception {
		return personalityApiService.userPersonalityResult(fbAccessToken);
	}
	

}
