package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetSharedGroupDataResult
{
	
	
	/// <summary>
	/// data for the requested keys
	/// </summary>
	
	public HashMap<String,SharedGroupDataRecord> Data;
	
	/// <summary>
	/// list of PlayFabId identifiers for the members of this group, if requested
	/// </summary>
	
	public String[] Members;
}
