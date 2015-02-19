package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RunCloudScriptRequest
{
	
	
	/// <summary>
	/// server action to trigger
	/// </summary>
	
	public String ActionId;
	
	/// <summary>
	/// parameters to pass into the action (If you use this, don't use ParamsEncoded)
	/// </summary>
	
	public Object Params;
	
	/// <summary>
	/// json-encoded parameters to pass into the action (If you use this, don't use Params)
	/// </summary>
	
	public String ParamsEncoded;
}
