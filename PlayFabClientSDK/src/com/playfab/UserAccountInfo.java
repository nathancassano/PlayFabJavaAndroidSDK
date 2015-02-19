package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UserAccountInfo
{
	
	
	/// <summary>
	/// unique identifier for the user account
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// timestamp indicating when the user account was created
	/// </summary>
	
	public Date Created;
	
	/// <summary>
	/// user account name in the PlayFab service
	/// </summary>
	
	public String Username;
	
	/// <summary>
	/// title-specific information for the user account
	/// </summary>
	
	public UserTitleInfo TitleInfo;
	
	/// <summary>
	/// personal information for the user which is considered more sensitive
	/// </summary>
	
	public UserPrivateAccountInfo PrivateInfo;
	
	/// <summary>
	/// user Facebook information, if a Facebook account has been linked
	/// </summary>
	
	public UserFacebookInfo FacebookInfo;
	
	/// <summary>
	/// user Steam information, if a Steam account has been linked
	/// </summary>
	
	public UserSteamInfo SteamInfo;
	
	/// <summary>
	/// user Gamecenter information, if a Gamecenter account has been linked
	/// </summary>
	
	public UserGameCenterInfo GameCenterInfo;
}
