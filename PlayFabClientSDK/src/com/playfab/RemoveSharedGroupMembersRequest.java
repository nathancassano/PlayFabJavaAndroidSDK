package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RemoveSharedGroupMembersRequest
{
	
	
	/// <summary>
	/// unique identifier for the shared group
	/// </summary>
	
	public String SharedGroupId;
	
	/// <summary>
	/// list of PlayFabId identifiers of users to remove from the shared group
	/// </summary>
	
	public String[] PlayFabIds;
}
