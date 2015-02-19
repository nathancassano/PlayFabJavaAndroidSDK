package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LoginResult
{
	
	
	/// <summary>
	/// a unique token authorizing the user and game at the server level, for the current session
	/// </summary>
	
	public String SessionTicket;
	
	/// <summary>
	/// player's unique PlayFabId
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// true if the account was newly created on this login
	/// </summary>
	
	public Boolean NewlyCreated;
}
