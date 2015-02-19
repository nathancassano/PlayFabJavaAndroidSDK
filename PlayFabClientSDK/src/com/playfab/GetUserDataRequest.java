package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetUserDataRequest
{
	
	
	/// <summary>
	/// specific keys to search for in the custom user data. Leave null to get all keys.
	/// </summary>
	
	public String[] Keys;
	
	/// <summary>
	/// PlayFabId of the user to load data for. Optional, defaults to yourself if not set.
	/// </summary>
	
	public String PlayFabId;
}
