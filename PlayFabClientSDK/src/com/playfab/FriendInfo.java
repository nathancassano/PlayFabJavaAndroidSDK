package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class FriendInfo
{
	
	
	/// <summary>
	/// PlayFab unique identifier for this friend
	/// </summary>
	
	public String FriendPlayFabId;
	
	/// <summary>
	/// PlayFab unique username for this friend
	/// </summary>
	
	public String Username;
	
	/// <summary>
	/// title-specific display name for this friend
	/// </summary>
	
	public String TitleDisplayName;
	
	/// <summary>
	/// tags which have been associated with this friend
	/// </summary>
	
	public String[] Tags;
	
	/// <summary>
	/// unique lobby identifier of the Game Server Instance to which this player is currently connected
	/// </summary>
	
	public String CurrentMatchmakerLobbyId;
	
	/// <summary>
	/// available Facebook information (if the user and PlayFab friend are also connected in Facebook)
	/// </summary>
	
	public UserFacebookInfo FacebookInfo;
	
	/// <summary>
	/// available Steam information (if the user and PlayFab friend are also connected in Steam)
	/// </summary>
	
	public UserSteamInfo SteamInfo;
	
	/// <summary>
	/// available Game Center information (if the user and PlayFab friend are also connected in Game Center)
	/// </summary>
	
	public UserGameCenterInfo GameCenterInfo;
}
