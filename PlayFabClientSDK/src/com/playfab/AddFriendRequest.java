package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class AddFriendRequest
{
	
	
	/// <summary>
	/// PlayFab identifier of the user to attempt to add to the local user's friend list
	/// </summary>
	
	public String FriendPlayFabId;
	
	/// <summary>
	/// PlayFab username of the user to attempt to add to the local user's friend list
	/// </summary>
	
	public String FriendUsername;
	
	/// <summary>
	/// email address of the user to attempt to add to the local user's friend list
	/// </summary>
	
	public String FriendEmail;
	
	/// <summary>
	/// title-specific display name of the user to attempt to add to the local user's friend list
	/// </summary>
	
	public String FriendTitleDisplayName;
}
