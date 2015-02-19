package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UpdateSharedGroupDataRequest
{
	
	
	/// <summary>
	/// unique identifier for the shared group
	/// </summary>
	
	public String SharedGroupId;
	
	/// <summary>
	/// key value pairs to be stored in the shared group - note that keys will be trimmed of whitespace, must not begin with a '!' character, and that null values will result in the removal of the key from the data set
	/// </summary>
	
	public HashMap<String,String> Data;
	
	/// <summary>
	/// permission to be applied to all user data keys in this request
	/// </summary>
	
	public UserDataPermission Permission;
}
