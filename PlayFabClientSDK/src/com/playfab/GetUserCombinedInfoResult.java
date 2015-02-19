package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetUserCombinedInfoResult
{
	
	
	/// <summary>
	/// PlayFabId of the owner of the combined info
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// account information for the user
	/// </summary>
	
	public UserAccountInfo AccountInfo;
	
	/// <summary>
	/// array of inventory items in the user's current inventory
	/// </summary>
	
	public ItemInstance[] Inventory;
	
	/// <summary>
	/// array of virtual currency balance(s) belonging to the user
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrency;
	
	/// <summary>
	/// user specific custom data
	/// </summary>
	
	public HashMap<String,UserDataRecord> Data;
	
	/// <summary>
	/// user specific read-only data
	/// </summary>
	
	public HashMap<String,UserDataRecord> ReadOnlyData;
}
