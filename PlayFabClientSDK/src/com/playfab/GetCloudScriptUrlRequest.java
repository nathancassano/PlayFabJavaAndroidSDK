package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetCloudScriptUrlRequest
{
	
	
	/// <summary>
	/// Server version to use. Defaults to 1 if left null
	/// </summary>
	
	public Integer Version;
	
	/// <summary>
	/// If true, run against the latest test revision of server logic. Defaults to false if left null
	/// </summary>
	
	public Boolean Testing;
}
