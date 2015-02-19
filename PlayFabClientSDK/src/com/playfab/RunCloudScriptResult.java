package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RunCloudScriptResult
{
	
	
	/// <summary>
	/// return values from the server action as a dynamic object
	/// </summary>
	
	public Object Results;
	
	/// <summary>
	/// return values from the server action as a json encoded string
	/// </summary>
	
	public String ResultsEncoded;
	
	/// <summary>
	/// any log statements generated during the run of this action
	/// </summary>
	
	public String ActionLog;
}
