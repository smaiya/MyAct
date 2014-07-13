package com.myact.facebook.restclients;

import java.util.List;

import android.util.Log;

import com.facebook.Request;
import com.facebook.Request.GraphUserListCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;

public class FacebookRestClients {

	public static void getFriendsList(){
		Log.d("DEBUG","Get FriendList");
		Request.newMyFriendsRequest(Session.getActiveSession(), new GraphUserListCallback() {
			
			@Override
			public void onCompleted(List<GraphUser> users, Response response) {
				Log.d("DEBUG","Get Friend List Complete");
				Log.d("DEBUG",response.toString());
				for(GraphUser user : users){
					Log.d("DEBUG", user.toString());
				}
			}
		}).executeAsync();
	}
	
	public static void getCurrentUserInfo(){
		Request.newMeRequest(Session.getActiveSession(), new Request.GraphUserCallback() {

            @Override
            public void onCompleted(GraphUser user, Response response) {
                if (user != null) {
                    // Display the parsed user info
                	Log.d("DEBUG","Get Current User Infor Complete");
    				Log.d("DEBUG", user.toString());
                }
            }
        }).executeAsync();
	}
}
