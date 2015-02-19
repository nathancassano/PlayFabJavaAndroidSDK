package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class MatchmakeResult
{
	
	
	/// <summary>
	/// unique lobby identifier of the server matched
	/// </summary>
	
	public String LobbyID;
	
	/// <summary>
	/// IP address of the server
	/// </summary>
	
	public String ServerHostname;
	
	/// <summary>
	/// port number to use for non-http communications with the server
	/// </summary>
	
	public Integer ServerPort;
	
	/// <summary>
	/// server authorization ticket (used by RedeemCoupon to validate user insertion into the game)
	/// </summary>
	
	public String Ticket;
	
	/// <summary>
	/// timestamp for when the server will expire, if applicable
	/// </summary>
	
	public String Expires;
	
	/// <summary>
	/// time in milliseconds the application is configured to wait on matchmaking results
	/// </summary>
	
	public Integer PollWaitTimeMS;
	
	/// <summary>
	/// result of match making process
	/// </summary>
	
	public MatchmakeStatus Status;
}
