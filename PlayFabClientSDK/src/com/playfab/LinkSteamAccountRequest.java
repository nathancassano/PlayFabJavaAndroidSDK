package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class LinkSteamAccountRequest
{
	
	
	/// <summary>
	/// authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte 0x08 should become "08")
	/// </summary>
	
	public String SteamTicket;
}
