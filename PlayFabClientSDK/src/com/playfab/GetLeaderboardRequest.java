package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetLeaderboardRequest
{
	
	
	/// <summary>
	/// statistic used to rank players for this leaderboard
	/// </summary>
	
	public String StatisticName;
	
	/// <summary>
	/// position in the leaderboard to start this listing (defaults to the first entry)
	/// </summary>
	
	public Integer StartPosition;
	
	/// <summary>
	/// maximum number of entries to retrieve
	/// </summary>
	
	public Integer MaxResultsCount;
}
