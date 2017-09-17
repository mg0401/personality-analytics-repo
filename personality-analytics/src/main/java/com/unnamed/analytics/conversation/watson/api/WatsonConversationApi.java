package com.unnamed.analytics.conversation.watson.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ClientURI;

import sun.misc.BASE64Encoder;

public class WatsonConversationApi {
	
	  public static final String URL = "url";
	    public static String USERNAME = "username";
	    public static String PASSWORD = "password";
	    public static String VERSION = "version";
	    public static String WORKSPACE_ID = "90b67f3f-91ac-4093-8be6-b2211a558f2d";

	    public static final String URL_DEFAULT = "https://gateway.watsonplatform.net/conversation/api";
	    public static final String PROFILE_PATH = "v1/workspaces/";
	    public static final String VERSION_PATH = "/message?version=2017-02-03";

	    UriBuilder uriBuilder;
	    ClientURI client;
	    
	    

	    public WatsonConversationApi(String userName, String password) {
	        
	        this.USERNAME = userName;
	        this.PASSWORD = password;
	        }
	    
	    //https://gateway.watsonplatform.net/personality-insights/api/v3/profile?version=2016-10-20&user=mohnish.a821@gmail.com:Gmohnish@88
	    public BufferedReader uriBuilder(String data) throws Exception {
	        
	        UriBuilder uriBuilder = UriBuilder.fromPath(URL_DEFAULT).path(PROFILE_PATH).path(WORKSPACE_ID).path(VERSION_PATH);
	        System.out.println("The URI" +uriBuilder.toString());
	        String authString = USERNAME + ":" + PASSWORD;
	        System.out.println("The auth:" +authString);
	        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
	        System.out.println(" auth string" +authStringEnc);
	        String url = "https://gateway.watsonplatform.net/conversation/api/v1/workspaces/90b67f3f-91ac-4093-8be6-b2211a558f2d/message?version=2017-02-03";
	        System.out.println("The URL: " +url);
	        ClientRequest request = new ClientRequest(url);
	        request.accept("application/json");
	        request.header("Authorization", "Basic " +authStringEnc);
	        request.body("application/json", data);
	        
	        System.out.println("The request: " +request.toString());
	        ClientResponse<String> response = request.post(String.class);
	        
	        System.out.println("The response is: " +response.toString());
	        
	        BufferedReader watsonOutputBufferReader = new BufferedReader(new InputStreamReader(
	                new ByteArrayInputStream(response.getEntity().getBytes())));
	            
	            return watsonOutputBufferReader;
	    }	    
	    
	    public static void main(String[] args) {
	    	
	    	WatsonConversationApi watsonApi = new WatsonConversationApi("4aaae618-ffe8-4b3f-84da-ce4ccc37f430", "SIuk5Idc8nnB");
		        try {
		        	String collectedData = "Cappuccino15 year old girl holds hands with her 1 year old son. People call her a no one knows he experienced a serious injury to his face while fighting for our country in the war. Re-post this if you are against bullying and stereotyping. I bet 88 of you won't,the other 22 arent heartless and will. Hi, my name is Amy Bruce. I am 7 years old, and I have severe lung cancer . I also have a large tumor in my brain, from repeated beatings. Doctors say I will die soon if this isn't fixed, and my family can't pay the bills. The Make A Wish Foundation, has agreed to donate 7 cents for every time this message is sent on. For those of you who send this along, I thank you so much, but for those who donause I ve Tried. Neither Would A Million Tears, I Know Because I've CriedMothers hold their children's hands for a short while, but their hearts forever....Happy Mothers Day e bills. The Make A Wish Foundation, has agreed to donate 7 cents for every time this message is sent on. For those of you who send this along, I thank you so much, but for those who donause I ve Tried. Neither Would A Million Tears, I Know Because I've CriedMothers hold their children's hands for a short while, Cappuccino15 year old girl holds hands with her 1 year old son. People call her a no one knows he experienced a serious injury to his face while fighting for our country in the war. Re-post this if you are against bullying and stereotyping. I bet 88 of you won't,the other 22 arent heartless and will. Hi, my name is Amy Bruce. I am 7 years old, and I have severe lung cancer . I also have a large tumor in my brain, from repeated beatings. Doctors say I will die soon if this isn't fixed, and my family can't pay the bills. The Make A Wish Foundation, has agreed to donate 7 cents for every time this message is sent on. For those of you who send this along, I thank you so much, but for those who donause I ve Tried. Neither Would A Million Tears, I Know Because Ive CriedMothers hold their childrens hands for a short wh";
		        	 BufferedReader outputJson = watsonApi.uriBuilder(collectedData);
		        } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }

}
