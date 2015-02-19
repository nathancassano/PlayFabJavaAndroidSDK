package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginWithFacebookRequest
{
	
	
	
	public String TitleId;
	
	/// <summary>
	/// unique identifier from Facebook for the user
	/// </summary>
	
	public String AccessToken;
	
	/// <summary>
	/// automatically create a PlayFab account if one is not currently linked to this Facebook account
	/// </summary>
	
	public Boolean CreateAccount;
}
