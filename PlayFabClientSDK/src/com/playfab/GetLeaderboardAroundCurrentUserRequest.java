package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetLeaderboardAroundCurrentUserRequest
{
	
	
	/// <summary>
	/// statistic used to rank players for this leaderboard
	/// </summary>
	
	public String StatisticName;
	
	/// <summary>
	/// maximum number of entries to retrieve
	/// </summary>
	
	public Integer MaxResultsCount;
}
