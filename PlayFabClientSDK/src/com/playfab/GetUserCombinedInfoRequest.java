package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class GetUserCombinedInfoRequest
{
	
	
	/// <summary>
	/// PlayFabId of the user to load info about. Defaults to yourself if not set.
	/// </summary>
	
	public String PlayFabId;
	
	/// <summary>
	/// If set to false, account info will not be returned (defaults to true)
	/// </summary>
	
	public Boolean GetAccountInfo;
	
	/// <summary>
	/// If set to false, inventory will not be returned (defaults to true). Inventory will never be returned for users other than yourself.
	/// </summary>
	
	public Boolean GetInventory;
	
	/// <summary>
	/// If set to false, virtual currency balances will not be returned (defaults to true). Currency balances will never be returned for users other than yourself.
	/// </summary>
	
	public Boolean GetVirtualCurrency;
	
	/// <summary>
	/// If set to false, custom user data will not be returned (defaults to true).
	/// </summary>
	
	public Boolean GetUserData;
	
	/// <summary>
	/// User custom data keys to return. Leave null to get all keys. For users other than yourself, only public data will be returned.
	/// </summary>
	
	public String[] UserDataKeys;
	
	/// <summary>
	/// If set to false, read-only user data will not be returned (defaults to true).
	/// </summary>
	
	public Boolean GetReadOnlyData;
	
	/// <summary>
	/// User read-only custom data keys to return. Leave null to get all keys. For users other than yourself, only public data will be returned.
	/// </summary>
	
	public String[] ReadOnlyDataKeys;
}
