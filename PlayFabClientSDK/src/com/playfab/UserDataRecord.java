package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UserDataRecord
{
	
	
	/// <summary>
	/// data stored for the specified user data key
	/// </summary>
	
	public String Value;
	
	/// <summary>
	/// timestamp for when this data was last updated
	/// </summary>
	
	public Date LastUpdated;
	
	/// <summary>
	/// indicates whether this data can be read by all users (public) or only the user (private)
	/// </summary>
	
	public UserDataPermission Permission;
}
