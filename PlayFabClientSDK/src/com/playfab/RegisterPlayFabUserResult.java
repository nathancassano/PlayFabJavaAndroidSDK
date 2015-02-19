package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RegisterPlayFabUserResult
{
	
	
	/// <summary>
	/// PlayFab unique identifier for this newly created account
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// a unique token identifying the user and game at the server level, for the current session
	/// </summary>
	
	public String SessionTicket;
	
	/// <summary>
	/// PlayFab unique user name
	/// </summary>
	
	public String Username;
}
