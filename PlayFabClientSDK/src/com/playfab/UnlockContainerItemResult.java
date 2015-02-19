package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class UnlockContainerItemResult
{
	
	
	/// <summary>
	/// unique instance identifier of the container unlocked
	/// </summary>
	
	public String UnlockedItemInstanceId;
	
	/// <summary>
	/// unique instance identifier of the key used to unlock the container, if applicable
	/// </summary>
	
	public String UnlockedWithItemInstanceId;
	
	/// <summary>
	/// items granted to the player as a result of unlocking the container
	/// </summary>
	
	public ItemInstance[] GrantedItems;
	
	/// <summary>
	/// virtual currency granted to the player as a result of unlocking the container
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrency;
}
