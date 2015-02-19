package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithSteamRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte 0x08 should become "08")
	/// </summary>
	
	public String SteamTicket;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this Steam account
	/// </summary>
	
	public Boolean CreateAccount;
}
