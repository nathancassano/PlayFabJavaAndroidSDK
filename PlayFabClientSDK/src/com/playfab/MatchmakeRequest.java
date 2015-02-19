package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class MatchmakeRequest
{
	
	
	/// <summary>
	/// build version to match against
	/// </summary>
	
	public String BuildVersion;
	
	/// <summary>
	/// region to match make against
	/// </summary>
	
	public Region Region;
	
	/// <summary>
	/// game mode to match make against
	/// </summary>
	
	public String GameMode;
	
	/// <summary>
	/// lobby identifier to match make against (used to select a specific server)
	/// </summary>
	
	public String LobbyId;
	
	/// <summary>
	/// [deprecated]
	/// </summary>
	
	public Boolean EnableQueue;
}
