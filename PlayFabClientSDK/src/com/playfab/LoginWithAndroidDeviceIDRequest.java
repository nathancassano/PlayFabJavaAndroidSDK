package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithAndroidDeviceIDRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// Android device identifier for the user's device
	/// </summary>
	
	public String AndroidDeviceId;
	
	/// <summary>
	/// specific Operating System version for the user's device
	/// </summary>
	
	public String OS;
	
	/// <summary>
	/// specific model of the user's device
	/// </summary>
	
	public String AndroidDevice;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this iOS device
	/// </summary>
	
	public Boolean CreateAccount;
}
