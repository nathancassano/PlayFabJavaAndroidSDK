package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class CartItem
{
	
	
	/// <summary>
	/// unique identifier for the catalog item
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// class name to which catalog item belongs
	/// </summary>
	
	public String ItemClass;
	
	/// <summary>
	/// unique instance identifier for this catalog item
	/// </summary>
	
	public String ItemInstanceId;
	
	/// <summary>
	/// display name for the catalog item
	/// </summary>
	
	public String DisplayName;
	
	/// <summary>
	/// description of the catalog item
	/// </summary>
	
	public String Description;
	
	/// <summary>
	/// the cost of the catalog item for each applicable virtual currency
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrencyPrices;
	
	/// <summary>
	/// the cost of the catalog item for each applicable real world currency
	/// </summary>
	
	public HashMap<String,Integer> RealCurrencyPrices;
	
	/// <summary>
	/// the amount of each applicable virtual currency which will be received as a result of purchasing this catalog item
	/// </summary>
	
	public HashMap<String,Integer> VCAmount;
}
