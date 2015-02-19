package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class SharedGroupDataRecord
{
	
	
	/// <summary>
	/// data stored for the specified group data key
	/// </summary>
	
	public String Value;
	
	/// <summary>
	/// PlayFabId of the user to last update this value
	/// </summary>
	
	public String LastUpdatedBy;
	
	/// <summary>
	/// timestamp for when this data was last updated
	/// </summary>
	
	public Date LastUpdated;
	
	/// <summary>
	/// indicates whether this data can be read by all users (public) or only members of the group (private)
	/// </summary>
	
	public UserDataPermission Permission;
}
