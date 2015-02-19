package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetUserInventoryResult
{
	
	
	/// <summary>
	/// array of inventory items in the user's current inventory
	/// </summary>
	
	public ItemInstance[] Inventory;
	
	/// <summary>
	/// array of virtual currency balance(s) belonging to the user
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrency;
}
