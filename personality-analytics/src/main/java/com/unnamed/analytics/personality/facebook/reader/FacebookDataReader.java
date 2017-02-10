package com.unnamed.analytics.personality.facebook.reader;

import java.util.Date;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Post;

import static java.lang.System.currentTimeMillis;

import java.io.BufferedWriter;

public class FacebookDataReader {

	private final FacebookClient facebookClient23;

	public FacebookDataReader(String accessToken) {
		facebookClient23 = new DefaultFacebookClient(accessToken,Version.VERSION_2_3);
	}

	public String postsReader() {
		
		StringBuffer fbDataBuffer = new StringBuffer();
		Date oneWeekAgo = new Date(currentTimeMillis() - 1000L * 60L * 60L * 24L * 6000L);
		System.out.println(" Data: " +oneWeekAgo);
		
		System.out.println("**** Posts Test  ****");
		Connection<Post> myFeed = facebookClient23.fetchConnection("me/feed",Post.class, Parameter.with("Until", oneWeekAgo));

		for (List<Post> myFeedConnectionPage : myFeed)
			for (Post post : myFeedConnectionPage) {
				
				String postType = post.getStatusType();
				
				if(postType!=null && !postType.isEmpty() && postType.equalsIgnoreCase("mobile_status_update")) {
					fbDataBuffer.append(post.getMessage());
				}	
				
			}
		return fbDataBuffer.toString();
	}
}
