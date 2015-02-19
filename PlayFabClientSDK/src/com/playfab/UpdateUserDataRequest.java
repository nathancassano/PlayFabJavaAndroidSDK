package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UpdateUserDataRequest
{
	
	
	/// <summary>
	/// data to be written to the user's custom data. A key with a null value will be removed, rather than being set to null.
	/// </summary>
	
	public HashMap<String,String> Data;
	
	/// <summary>
	/// Permission to be applied to all user data keys written in this request. Defaults to "private" if not set.
	/// </summary>
	
	public UserDataPermission Permission;
}
