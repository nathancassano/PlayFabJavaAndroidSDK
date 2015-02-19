package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UserTitleInfo
{
	
	
	/// <summary>
	/// name of the user, as it is displayed in-game
	/// </summary>
	
	public String DisplayName;
	
	/// <summary>
	/// source by which the user first joined the game, if known
	/// </summary>
	
	public UserOrigination Origination;
	
	/// <summary>
	/// timestamp indicating when the user was first associated with this game (this can differ significantly from when the user first registered with PlayFab)
	/// </summary>
	
	public Date Created;
	
	/// <summary>
	/// timestamp for the last user login for this title
	/// </summary>
	
	public Date LastLogin;
	
	/// <summary>
	/// timestamp indicating when the user first signed into this game (this can differ from the Created timestamp, as other events, such as issuing a beta key to the user, can associate the title to the user)
	/// </summary>
	
	public Date FirstLogin;
	
	/// <summary>
	/// boolean indicating whether or not the user is currently banned for a title
	/// </summary>
	
	public Boolean isBanned;
}
