package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithGameCenterRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// unique Game Center player id
	/// </summary>
	
	public String PlayerId;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this Game Center id
	/// </summary>
	
	public Boolean CreateAccount;
}
