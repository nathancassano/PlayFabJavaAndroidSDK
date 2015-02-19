package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithIOSDeviceIDRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// vendor-specific iOS identifier for the user's device
	/// </summary>
	
	public String DeviceId;
	
	/// <summary>
	/// specific Operating System version for the user's device
	/// </summary>
	
	public String OS;
	
	/// <summary>
	/// specific model of the user's device
	/// </summary>
	
	public String DeviceModel;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this iOS device
	/// </summary>
	
	public Boolean CreateAccount;
}
