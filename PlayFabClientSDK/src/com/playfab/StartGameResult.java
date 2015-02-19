package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class StartGameResult
{
	
	
	/// <summary>
	/// unique identifier for the lobby of the server started
	/// </summary>
	
	public String LobbyID;
	
	/// <summary>
	/// server IP address
	/// </summary>
	
	public String ServerHostname;
	
	/// <summary>
	/// port on the server to be used for communication
	/// </summary>
	
	public Integer ServerPort;
	
	/// <summary>
	/// unique identifier for the server
	/// </summary>
	
	public String Ticket;
	
	/// <summary>
	/// timestamp for when the server should expire, if applicable
	/// </summary>
	
	public String Expires;
	
	/// <summary>
	/// password required to log into the server
	/// </summary>
	
	public String Password;
}
