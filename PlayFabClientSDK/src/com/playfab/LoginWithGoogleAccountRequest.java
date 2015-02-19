package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithGoogleAccountRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// unique token from Google Play for the user
	/// </summary>
	
	public String AccessToken;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this Google account
	/// </summary>
	
	public Boolean CreateAccount;
}
