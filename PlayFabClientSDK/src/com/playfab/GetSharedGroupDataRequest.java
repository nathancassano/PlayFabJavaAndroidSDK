package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetSharedGroupDataRequest
{
	
	
	/// <summary>
	/// unique identifier for the shared group
	/// </summary>
	
	public String SharedGroupId;
	
	/// <summary>
	/// specific keys to retrieve from the shared group (if not specified, all keys will be returned, while an empty array indicates that no keys should be returned)
	/// </summary>
	
	public String[] Keys;
	
	/// <summary>
	/// if true, return the list of all members of the shared group
	/// </summary>
	
	public Boolean GetMembers;
}
