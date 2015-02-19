package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PlayerLeaderboardEntry
{
	
	
	/// <summary>
	/// PlayFab unique identifier of the user for this leaderboard entry
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// title-specific display name of the user for this leaderboard entry
	/// </summary>
	
	public String DisplayName;
	
	/// <summary>
	/// specific value of the user's statistic
	/// </summary>
	
	public Integer StatValue;
	
	/// <summary>
	/// user's overall position in the leaderboard
	/// </summary>
	
	public Integer Position;
}
