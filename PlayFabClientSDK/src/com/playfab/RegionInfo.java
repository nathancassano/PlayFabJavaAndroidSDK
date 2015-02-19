package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RegionInfo
{
	
	
	/// <summary>
	/// unique identifier for the region
	/// </summary>
	
	public Region Region;
	
	/// <summary>
	/// name of the region
	/// </summary>
	
	public String Name;
	
	/// <summary>
	/// indicates whether the server specified is available in this region
	/// </summary>
	
	public Boolean Available;
	
	/// <summary>
	/// url to ping to get roundtrip time
	/// </summary>
	
	public String PingUrl;
}
