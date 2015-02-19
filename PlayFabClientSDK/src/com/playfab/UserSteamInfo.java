package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UserSteamInfo
{
	
	
	/// <summary>
	/// Steam identifier
	/// </summary>
	
	public String SteamId;
	
	/// <summary>
	/// the country in which the player resides, from Steam data
	/// </summary>
	
	public String SteamCountry;
	
	/// <summary>
	/// currency type set in the user Steam account
	/// </summary>
	
	public Currency SteamCurrency;
	
	/// <summary>
	/// what stage of game ownership the user is listed as being in, from Steam
	/// </summary>
	
	public TitleActivationStatus SteamActivationStatus;
}
