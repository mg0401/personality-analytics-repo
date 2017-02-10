package com.unnamed.analytics.personality.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.unnamed.analytics.personality.controller.PersonalityApiServiceController;

public class PersonalityApiApp extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public PersonalityApiApp() {
		singletons.add(new PersonalityApiServiceController());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
}
