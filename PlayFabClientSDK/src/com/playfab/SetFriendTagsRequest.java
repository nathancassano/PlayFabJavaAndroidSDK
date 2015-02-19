package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class SetFriendTagsRequest
{
	
	
	/// <summary>
	/// PlayFab identifier of the friend account to which the tag(s) should be applied
	/// </summary>
	
	public String FriendPlayFabId;
	
	/// <summary>
	/// array of tags to set on the friend account
	/// </summary>
	
	public String[] Tags;
}
