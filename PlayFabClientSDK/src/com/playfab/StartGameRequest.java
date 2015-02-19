package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class StartGameRequest
{
	
	
	/// <summary>
	/// version information for the build of the game server which is to be started
	/// </summary>
	
	public String BuildVersion;
	
	/// <summary>
	/// the region to associate this server with for match filtering
	/// </summary>
	
	public Region Region;
	
	/// <summary>
	/// the title-defined game mode this server is to be running (defaults to 0 if there is only one mode)
	/// </summary>
	
	public String GameMode;
	
	/// <summary>
	/// informs the service that a password is associated with this server
	/// </summary>
	
	public Boolean PasswordRestricted;
	
	/// <summary>
	/// custom command line argument when starting game server process
	/// </summary>
	
	public String CustomCommandLineData;
}
