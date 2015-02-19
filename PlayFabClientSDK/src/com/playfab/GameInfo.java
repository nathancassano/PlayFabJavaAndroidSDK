package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GameInfo
{
	
	
	/// <summary>
	/// region to which this server is associated
	/// </summary>
	
	public Region Region;
	
	/// <summary>
	/// unique lobby identifier for this game server
	/// </summary>
	
	public String LobbyID;
	
	/// <summary>
	/// build version this server is running
	/// </summary>
	
	public String BuildVersion;
	
	/// <summary>
	/// game mode this server is running
	/// </summary>
	
	public String GameMode;
	
	/// <summary>
	/// maximum players this server can support
	/// </summary>
	
	public Integer MaxPlayers;
	
	/// <summary>
	/// array of strings of current player names on this server (note that these are PlayFab usernames, as opposed to title display names)
	/// </summary>
	
	public String[] PlayerUserIds;
	
	/// <summary>
	/// duration in seconds this server has been running
	/// </summary>
	
	public Integer RunTime;
	
	/// <summary>
	/// game specific string denoting server configuration
	/// </summary>
	
	public String GameServerState;
}
