package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PurchasedItem
{
	
	
	/// <summary>
	/// unique instance identifier for this catalog item
	/// </summary>
	
	public String ItemInstanceId;
	
	/// <summary>
	/// unique identifier for the catalog item
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// catalog version for the item purchased
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// display name for the catalog item
	/// </summary>
	
	public String DisplayName;
	
	/// <summary>
	/// currency type for the cost of the catalog item
	/// </summary>
	
	public String UnitCurrency;
	
	/// <summary>
	/// cost of the catalog item in the given currency
	/// </summary>
	
	public Integer UnitPrice;
	
	/// <summary>
	/// array of unique items that were awarded when this catalog item was purchased
	/// </summary>
	
	public String[] BundleContents;
}
